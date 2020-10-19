package com.anry200.thepokedex.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anry200.thepokedex.R
import com.anry200.thepokedex.presentation.details.PokemonDetailsFragment
import com.anry200.thepokedex.presentation.list.PokemonListFragment


class MainActivity : AppCompatActivity(), Router {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openPokemonList()
    }

    override fun openPokemonList() {
        val fragment = PokemonListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment, null)
            .commit()
    }

    override fun openPokemonDetails(id: String) {
        val fragment = PokemonDetailsFragment.newInstance(id)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment, null)
            .addToBackStack(null)
            .commit()
    }
}