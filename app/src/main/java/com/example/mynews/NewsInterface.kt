package com.example.mynews


import com.example.mynews.modelclasses.Source
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {
    @GET("latest?")
    fun getNews(
        @Query("apikey") apikey:String,
        @Query("country") country:String,
        @Query("language") language:String,
        @Query("category") category:String
    ): Call<Source>
}