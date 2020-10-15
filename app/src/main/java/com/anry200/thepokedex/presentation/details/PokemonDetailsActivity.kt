package com.anry200.thepokedex.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anry200.thepokedex.R
import kotlinx.android.synthetic.main.item_pokemon.name

const val PARAM_POKEMON_ID = "param.pokemon.id"
class PokemonDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemonId = intent.getStringExtra(PARAM_POKEMON_ID)

        name.text = pokemonId
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

