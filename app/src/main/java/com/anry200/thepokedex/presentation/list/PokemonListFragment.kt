package com.anry200.thepokedex.presentation.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.anry200.thepokedex.R
import com.anry200.thepokedex.domain.Pokemon
import com.anry200.thepokedex.presentation.Router
import com.anry200.thepokedex.presentation.adapter.PokemonListAdapter
import com.anry200.thepokedex.presentation.details.PokemonDetailsFragment
import kotlinx.android.synthetic.main.fragment_pokemon_list.errorView
import kotlinx.android.synthetic.main.fragment_pokemon_list.loadingView
import kotlinx.android.synthetic.main.fragment_pokemon_list.recyclerView


class PokemonListFragment: Fragment(R.layout.fragment_pokemon_list) {
    private val adapter = PokemonListAdapter()
    private val viewModel by viewModels<PokemonListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = adapter

        adapter.pokemonOnClickListener = object : PokemonListAdapter.PokemonItemOnClickListener {
            override fun onClicked(id: String) {
                (requireActivity() as? Router)?.openPokemonDetails(id)
            }
        }

        viewModel.isLoadingLiveData.observe(viewLifecycleOwner, Observer {
            loadingView.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        viewModel.isErrorLiveData.observe(viewLifecycleOwner, Observer {
            errorView.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })

        viewModel.contentLiveData.observe(viewLifecycleOwner, Observer { data ->
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