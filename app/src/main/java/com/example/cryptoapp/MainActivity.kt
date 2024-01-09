package com.example.cryptoapp

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.cryptoapp.data.ModelClass
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.interfaces.RetrofitInterfaces
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = "Crypto App"


        GlobalScope.launch(Dispatchers.Main) {
            fetchData()
        }
        // Ensure that the program doesn't exit immediately
        readlnOrNull()

}


    suspend fun fetchData() {
        val apiService = RetrofitHelper.getInstance().create(RetrofitInterfaces::class.java)
//        val call: Call<ModelClass> = apiService.getData()
        try {
            val post: ModelClass = apiService.getData()
            val adapter = Adapter(this@MainActivity, post.data)

            binding.rv.layoutManager =LinearLayoutManager(this)
            binding.rv.adapter = adapter
            // Handle the retrieved data
            println(post)
            Log.e("data fetching", "Successfull" )
            Toast.makeText(this@MainActivity, "$post.toString() successfully", Toast.LENGTH_LONG).show()
            binding.progressBar.visibility = View.INVISIBLE
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_LONG).show()
            Log.e("data fetching", "$e.message " )
            binding.progressBar.visibility = View.INVISIBLE
            println("Error: ${e.message}")
        }

    }

}