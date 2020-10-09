package com.anry200.thepokedex.presentation

import android.os.Handler
import com.anry200.thepokedex.domain.PokemonRepository
import kotlin.random.Random

class MainPresenter(val repository: PokemonRepository) {
    private var view: MainView? = null

    fun loadData() {
        view?.showLoading()

        Handler().postDelayed({
            if (Random.nextInt() % 10  == 0) {
                view?.showError()
            } else {
                val data = repository.getPokemonList()
                view?.showContent()
                view?.setData(data)
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