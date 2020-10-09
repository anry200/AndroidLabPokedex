package com.anry200.thepokedex.data

import com.anry200.thepokedex.domain.Pokemon
import com.anry200.thepokedex.domain.PokemonRepository
import com.anry200.thepokedex.domain.pokemonList

class PokemonRepositoryImpl : PokemonRepository {
    override fun getPokemonList(): List<Pokemon> = pokemonList
}