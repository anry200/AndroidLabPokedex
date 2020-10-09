package com.anry200.thepokedex.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.anry200.thepokedex.R
import com.anry200.thepokedex.data.PokemonRepositoryImpl
import com.anry200.thepokedex.domain.Pokemon
import com.anry200.thepokedex.domain.PokemonRepository
import com.anry200.thepokedex.presentation.adapter.PokemonListAdapter
import kotlinx.android.synthetic.main.activity_main.errorView
import kotlinx.android.synthetic.main.activity_main.loadingView
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {
    private val adapter = PokemonListAdapter()
    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter

        viewModel.isLoadingLiveData.observe(this, Observer {
            loadingView.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        viewModel.isErrorLiveData.observe(this, Observer {
            errorView.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        viewModel.contentLiveData.observe(this, Observer { data ->
            recyclerView.visibility = if (data.isNotEmpty()) { //bad
                View.VISIBLE
            } else {
                View.GONE
            }
            setData(data)
        })

        viewModel.loadData()
    }

    fun setData(data: List<Pokemon>) {
        adapter.submitList(data)
    }
}