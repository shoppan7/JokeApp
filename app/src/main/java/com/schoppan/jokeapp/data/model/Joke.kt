package com.schoppan.jokeapp.data.model

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("icon_url") val iconUrl: String,
    @SerializedName("value") val joke: String
)
