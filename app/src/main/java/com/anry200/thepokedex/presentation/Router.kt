package com.anry200.thepokedex.presentation

interface Router {
    fun openPokemonList()
    fun openPokemonDetails(id: String)
}