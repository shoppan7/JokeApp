package com.schoppan.jokeapp.presenter

import com.schoppan.jokeapp.data.model.SearchResponse
import com.schoppan.jokeapp.data.repository.JokeRepository
import com.schoppan.jokeapp.ui.searchjoke.SearchJokeContract
import retrofit2.Call
import retrofit2.Response

class SearchJokePresenter(
    private var view: SearchJokeContract.View?,
    private val repository: JokeRepository
) : SearchJokeContract.Presenter {

    override fun searchJokes(query: String) {
        view?.showLoading()

        repository.searchJokes(query).enqueue(object : Callback<SearchResponse> {
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                view?.hideLoading()
                if (response.isSuccessful && response.body() != null) {
                    val jokes = response.body()!!.result
                    if (jokes.isNotEmpty()) {
                        view?.showJoke(jokes.random().joke)
                    } else {
                        view?.showError("Nenhuma piada encontrada!")
                    }
                } else {
                    view?.showError("Erro ao buscar piadas")
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                view?.hideLoading()
                view?.showError("Falha na conexão: ${t.localizedMessage}")
            }
        })
    }

    override fun onDestroy() {
        view = null
    }
}