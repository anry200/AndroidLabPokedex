package com.anry200.thepokedex.presentation

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anry200.thepokedex.data.PokemonRepositoryImpl
import com.anry200.thepokedex.domain.Pokemon
import com.anry200.thepokedex.domain.PokemonRepository
import kotlin.random.Random

class MainViewModel: ViewModel() {
    private val repository: PokemonRepository = PokemonRepositoryImpl()

    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState


    fun loadData() {
        _viewState.value = ViewState.Loading

        Handler().postDelayed({
            if (Random.nextInt() % 10  == 0) {
                _viewState.value = ViewState.Error
            } else {
                val data = repository.getPokemonList()
                _viewState.value = ViewState.Content(data)
            }
        }, 3000)
    }
}


sealed class ViewState {
    object Loading: ViewState()
    object Error: ViewState()
    data class Content(val data: List<Pokemon>): ViewState()
}