package com.schoppan.jokeapp.data.api

import com.schoppan.jokeapp.data.model.Joke
import com.schoppan.jokeapp.data.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisApi {
    @GET("jokes/random")
    fun getRandomJoke(): Call<Joke>

    @GET("jokes/search")
    fun searchJokes(@Query("query") query: String): Call<SearchResponse>

}