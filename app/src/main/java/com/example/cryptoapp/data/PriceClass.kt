package com.example.cryptoapp.data

import com.google.gson.annotations.SerializedName

data class PriceClass (
    @SerializedName("price") val price:Double)