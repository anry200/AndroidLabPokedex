package com.anry200.thepokedex.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.anry200.thepokedex.R
import com.anry200.thepokedex.data.PokemonRepositoryImpl
import com.anry200.thepokedex.domain.Pokemon
import com.anry200.thepokedex.domain.PokemonRepository
import com.anry200.thepokedex.presentation.adapter.PokemonListAdapter
import kotlinx.android.synthetic.main.activity_main.errorView
import kotlinx.android.synthetic.main.activity_main.loadingView
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity(), MainView {
    private val adapter = PokemonListAdapter()
    private val repository: PokemonRepository = PokemonRepositoryImpl()
    private val presenter = MainPresenter(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter

        presenter.attachView(this)

        presenter.loadData()
    }

    override fun render(state: ViewState) {

        when (state) {
            is ViewState.Loading -> {
                showLoading()
            }

            is ViewState.Error -> {
                showError()
            }

            is ViewState.Content -> {
                showContent()
                setData(state.data)
            }
        }
    }

    fun showLoading() {
        loadingView.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        errorView.visibility = View.GONE
    }

    fun showContent() {
        loadingView.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
        errorView.visibility = View.GONE
    }

    fun showError() {
        loadingView.visibility = View.GONE
        recyclerView.visibility = View.GONE
        errorView.visibility = View.VISIBLE
    }

    fun setData(data: List<Pokemon>) {
        adapter.submitList(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}