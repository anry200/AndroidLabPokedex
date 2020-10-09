package com.anry200.thepokedex.presentation

import android.os.Handler
import com.anry200.thepokedex.domain.Pokemon
import com.anry200.thepokedex.domain.PokemonRepository
import kotlin.random.Random

class MainPresenter(val repository: PokemonRepository) {
    private var view: MainView? = null

    fun loadData() {
        view?.render(ViewState.Loading)

        Handler().postDelayed({
            if (Random.nextInt() % 10  == 0) {
                view?.render(ViewState.Error)
            } else {
                val data = repository.getPokemonList()
                view?.render(ViewState.Content(data))
            }
        }, 3000)
    }

    fun attachView(activity: MainView) {
        this.view = activity
    }

    fun detachView() {
        this.view = null
    }
}

sealed class ViewState {
    object Loading: ViewState()
    object Error: ViewState()
    data class Content(val data: List<Pokemon>): ViewState()
    //data class ErrorState(val th: Throwable): ViewState()
}