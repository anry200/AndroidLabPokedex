package com.anry200.thepokedex.presentation

import com.anry200.thepokedex.domain.PokemonRepository

class MainPresenter(val repository: PokemonRepository) {
    private var view: MainView? = null

    fun loadData() {
        val data = repository.getPokemonList()
        view?.setData(data)
    }

    fun attachView(activity: MainView) {
        this.view = activity
    }

    fun detachView() {
        this.view = null
    }
}