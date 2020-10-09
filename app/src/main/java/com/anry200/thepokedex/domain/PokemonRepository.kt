package com.anry200.thepokedex.domain

interface PokemonRepository {
    fun getPokemonList(): List<Pokemon>
}