package com.schoppan.jokeapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.schoppan.jokeapp.R
import com.schoppan.jokeapp.data.repository.JokeRepository
import com.schoppan.jokeapp.presenter.SearchJokePresenter
import com.schoppan.jokeapp.ui.searchjoke.SearchJokeContract

class SearchJokeFragment : Fragment(), SearchJokeContract.View {

    private lateinit var presenter: SearchJokeContract.Presenter
    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_joke, container, false)

        searchEditText = view.findViewById(R.id.searchEditText)
        searchButton = view.findViewById(R.id.searchButton)
        resultTextView = view.findViewById(R.id.resultTextView)
        progressBar = view.findViewById(R.id.progressBar)

        presenter = SearchJokePresenter(this, JokeRepository())

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            if (query.isNotEmpty()) {
                presenter.searchJokes(query)
            } else {
                showError("Digite um texto para buscar")
            }
        }

        return view
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showJoke(joke: String) {
        resultTextView.text = joke
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDestroy()
    }
}