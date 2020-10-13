package com.anry200.thepokedex.domain

/**
 * It is all about Pokemons :)
 */
interface PokemonRepository {
    /**
     * Some API calls are network calls, which cannot be done on MainThread
     *
     * Possible solutions are:
     * 1. Use callback - current one
     * pros:
     * - simple
     * cons:
     * - a lot of boiler plate code
     * - callback hell for nested calls
     *
     * 2. RxJava - use Single
     * pros:
     * - industrial standard in fact
     * - no callback hell
     * - advanced error handling
     * cons:
     * - it requires knowledge about library
     *
     * 3. Kotlin Coroutines - add "suspend" to each call
     * pros:
     * - language feature
     * cons:
     * - error handling: Throw error vs Either.
     * Error messages can be delivered using Result or Either
     * Do not use empty list or null as error state
     */

    interface ApiCallback<T> {
        fun onSuccess(data: T)
        fun onError()
    }

    fun getPokemonList(callback: ApiCallback<List<Pokemon>>)

    fun getPokemonById(id: String, callback: ApiCallback<PokemonDetails>)
}