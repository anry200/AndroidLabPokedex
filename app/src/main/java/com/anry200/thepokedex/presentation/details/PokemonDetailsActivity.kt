package com.anry200.thepokedex.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.anry200.thepokedex.R
import com.anry200.thepokedex.domain.PokemonDetails
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_details.abilities
import kotlinx.android.synthetic.main.activity_pokemon_details.image
import kotlinx.android.synthetic.main.item_pokemon.name

const val PARAM_POKEMON_ID = "param.pokemon.id"
class PokemonDetailsActivity : AppCompatActivity() {
    val viewModel by viewModels<PokemonDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemonId = intent.getStringExtra(PARAM_POKEMON_ID) ?: "1" //TODO: add error handling

        viewModel.pokemonDetailsLiveData.observe(this, Observer { pokemonDetails ->
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

    companion object {
        fun openDetails(context: Context, id: String) {
            val intent = Intent(context, PokemonDetailsActivity::class.java)

            val bundle = Bundle()
            bundle.putString(PARAM_POKEMON_ID, id)
            intent.putExtras(bundle)

            context.startActivity(intent)
        }
    }
}

