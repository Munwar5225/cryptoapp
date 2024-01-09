package com.example.cryptoapp.data

import com.google.gson.annotations.SerializedName

data class DataModel (val name:String, val symbol:String,

                      @SerializedName("quote") val quote:Quote)
