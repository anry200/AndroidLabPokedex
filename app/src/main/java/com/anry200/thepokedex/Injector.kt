package com.anry200.thepokedex

import com.anry200.thepokedex.data.PokedexApiService
import com.anry200.thepokedex.data.PokemonRepositoryImpl
import com.anry200.thepokedex.data.createPokedexApiService
import com.anry200.thepokedex.domain.PokemonRepository

object Injector {
    val api: PokedexApiService = createPokedexApiService() //TODO: use DI
    val repository : PokemonRepository by lazy {  PokemonRepositoryImpl(api) }
}