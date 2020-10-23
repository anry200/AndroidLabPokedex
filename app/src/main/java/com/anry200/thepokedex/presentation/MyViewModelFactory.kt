package com.anry200.thepokedex.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anry200.thepokedex.App
import com.anry200.thepokedex.presentation.details.PokemonDetailsViewModel
import com.anry200.thepokedex.presentation.list.PokemonListViewModel

class MyViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repository = App.instance.appComponent.repository()

        return when(modelClass) {
            PokemonListViewModel::class.java -> PokemonListViewModel(repository)
            PokemonDetailsViewModel::class.java -> PokemonDetailsViewModel(repository)
            else -> throw IllegalArgumentException("Wrong ViewModel ${modelClass.canonicalName}")
        } as T
    }
}