package com.anry200.thepokedex.presentation.details

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.anry200.thepokedex.R
import com.anry200.thepokedex.domain.PokemonDetails
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pokemon_details.abilities
import kotlinx.android.synthetic.main.fragment_pokemon_details.image
import kotlinx.android.synthetic.main.item_pokemon.name

const val PARAM_POKEMON_ID = "param.pokemon.id"
class PokemonDetailsFragment : Fragment(R.layout.fragment_pokemon_details) {
    private val viewModel: PokemonDetailsViewModel by viewModels()

    companion object {
        fun newInstance(id: String): PokemonDetailsFragment {
            val fragment = PokemonDetailsFragment()
            val bundle = bundleOf(
                PARAM_POKEMON_ID to id
            )
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonId = requireArguments().getString(PARAM_POKEMON_ID) ?: "1" //TODO: add error handling

        viewModel.pokemonDetailsLiveData.observe(viewLifecycleOwner, Observer { pokemonDetails ->
            if (pokemonDetails != null) {
                showPokemonDetails(pokemonDetails)
            }
        })

        viewModel.loadPokemonData(pokemonId)
    }

    private fun showPokemonDetails(pokemon: PokemonDetails) {
        name.text = pokemon.name

        val abilitiesNames: String = pokemon.abilities.joinToString { it }
        abilities.text = abilitiesNames

        Picasso.get()
            .load(pokemon.imageUrl)
            .into(image)
    }
}

