package com.schoppan.jokeapp.network

import com.google.gson.Gson
import com.schoppan.jokeapp.data.api.ChuckNorrisApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.chucknorris.io/"

    val api: ChuckNorrisApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChuckNorrisApi::class.java)
    }
}