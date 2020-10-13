package com.anry200.thepokedex.data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * This is API service.
 *
 * See API description at https://pokeapi.co/
 */

//https://pokeapi.co/
//https://bulbapedia.bulbagarden.net/wiki/Bulbasaur_(Pok%C3%A9mon)
interface PokedexApiService {

    /**
     * See for details: https://pokeapi.co/api/v2/pokemon
     */
    @GET("pokemon")
    fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): Call<PokemonListResponse>

    /**
     * See for details: https://pokeapi.co/api/v2/pokemon/bulbasaur
     */
    @GET("pokemon/{name}")
    fun fetchPokemonInfo(@Path("name") name: String): Call<PokemonInfoResponse>
}

fun createPokedexApiService(): PokedexApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(PokedexApiService::class.java)
}