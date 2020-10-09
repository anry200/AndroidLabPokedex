package com.anry200.thepokedex.presentation

import com.anry200.thepokedex.domain.Pokemon

interface MainView {
    fun render(view: ViewState)
}