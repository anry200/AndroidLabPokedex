package com.anry200.thepokedex.di

import com.anry200.thepokedex.data.PokedexApiService
import com.anry200.thepokedex.data.PokemonRepositoryImpl
import com.anry200.thepokedex.data.createPokedexApiService
import com.anry200.thepokedex.domain.PokemonRepository
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun providesApi(): PokedexApiService = createPokedexApiService()

    @Provides
    fun providesRepository(api: PokedexApiService): PokemonRepository
        = PokemonRepositoryImpl(api)
}