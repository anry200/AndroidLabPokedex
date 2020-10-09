package com.anry200.thepokedex.presentation

import com.anry200.thepokedex.domain.Pokemon

interface MainView {
    fun setData(data: List<Pokemon>)

    fun showLoading()
    fun showContent()
    fun showError()
}