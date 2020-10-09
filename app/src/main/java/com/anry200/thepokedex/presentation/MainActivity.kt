package com.anry200.thepokedex.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anry200.thepokedex.R
import com.anry200.thepokedex.data.PokemonRepositoryImpl
import com.anry200.thepokedex.domain.PokemonRepository
import com.anry200.thepokedex.presentation.adapter.PokemonListAdapter
import kotlinx.android.synthetic.main.activity_main.recyclerView

class MainActivity : AppCompatActivity() {
    private val adapter = PokemonListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adapter

        val repository: PokemonRepository = PokemonRepositoryImpl()

        adapter.submitList(repository.getPokemonList())
    }
}