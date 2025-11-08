package com.schoppan.jokeapp.ui.searchjoke

interface SearchJokeContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showJoke(joke: String)
        fun showError(message: String)
    }

    interface Presenter {
        fun searchJokes(query: String)
        fun onDestroy()
    }

}