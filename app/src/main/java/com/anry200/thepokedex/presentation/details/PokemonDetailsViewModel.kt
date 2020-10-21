package com.anry200.thepokedex.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anry200.thepokedex.App
import com.anry200.thepokedex.domain.PokemonDetails
import com.anry200.thepokedex.domain.PokemonRepository

class PokemonDetailsViewModel : ViewModel() {
    private val repository: PokemonRepository = App.instance.appComponent.repository()

    private val _pokemonDetailsLiveData = MutableLiveData<PokemonDetails>()
    val pokemonDetailsLiveData: LiveData<PokemonDetails> = _pokemonDetailsLiveData

    fun loadPokemonData(id: String) {
        //TODO: add Loading

        repository.getPokemonById(id, object: PokemonRepository.ApiCallback<PokemonDetails> {
            override fun onSuccess(data: PokemonDetails) {
                _pokemonDetailsLiveData.postValue(data)
            }

            override fun onError() {
               //TODO: handle error
            }
        })
    }
}