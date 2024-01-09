package com.example.cryptoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.data.DataModel
import com.example.cryptoapp.data.ModelClass
import com.example.cryptoapp.databinding.ItemViewBinding

class Adapter(private val context:Context, private var data:List<DataModel>):RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder( val binding: ItemViewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemViewBinding.inflate(LayoutInflater.from(context),parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvName.text = data[position].name
        holder.binding.tvPrice.text = data[position].quote.USD.price.toString()
        holder.binding.tvSymbol.text = data[position].symbol
    }
}