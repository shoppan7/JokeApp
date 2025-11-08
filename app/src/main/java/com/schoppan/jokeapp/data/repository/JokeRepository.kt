package com.schoppan.jokeapp.data.repository

import com.schoppan.jokeapp.data.model.Joke
import com.schoppan.jokeapp.data.model.SearchResponse
import com.schoppan.jokeapp.network.RetrofitInstance
import retrofit2.Call

class JokeRepository {

    private val api = RetrofitInstance.api

    fun searchJokes(query: String): Call<SearchResponse> = api.searchJokes(query)
    fun getRandomJoke(): Call<Joke> = api.getRandomJoke()

}