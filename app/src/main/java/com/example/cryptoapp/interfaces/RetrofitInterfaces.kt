package com.example.cryptoapp.interfaces

import com.example.cryptoapp.data.ModelClass
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface RetrofitInterfaces {
    @Headers(
        "X-CMC_PRO_API_KEY:03747806-96f5-49c4-8dba-91687d0aa237"
    )
    @GET("latest")
    suspend fun getData() : ModelClass
}