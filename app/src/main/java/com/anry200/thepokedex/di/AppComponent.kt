package com.anry200.thepokedex.di

import com.anry200.thepokedex.domain.PokemonRepository
import com.anry200.thepokedex.presentation.list.PokemonListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(fragment: PokemonListFragment)
    fun repository(): PokemonRepository
}