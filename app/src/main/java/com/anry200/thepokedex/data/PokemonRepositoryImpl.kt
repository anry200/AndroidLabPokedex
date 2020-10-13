package com.anry200.thepokedex.data

import com.anry200.thepokedex.domain.Pokemon
import com.anry200.thepokedex.domain.PokemonDetails
import com.anry200.thepokedex.domain.PokemonRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepositoryImpl : PokemonRepository {
    private val api: PokedexApiService = createPokedexApiService() //TODO: use DI

    override fun getPokemonList(callback: PokemonRepository.ApiCallback<List<Pokemon>>) {
        api.fetchPokemonList().enqueue(object : Callback<PokemonListResponse> {
            override fun onResponse(call: Call<PokemonListResponse>, response: Response<PokemonListResponse>) {
                val pokemonListResponse = response.body()

                if (response.isSuccessful && pokemonListResponse != null) {

                    val pokemonList = pokemonListResponse.results.map { pokemonPartialInfoDto ->
                        Pokemon(pokemonPartialInfoDto.id, pokemonPartialInfoDto.name, pokemonPartialInfoDto.imageUrl)
                    }

                    callback.onSuccess(pokemonList)
                } else {
                    callback.onError()
                }
            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                callback.onError()
            }
        })
    }

    override fun getPokemonById(id: String, callback: PokemonRepository.ApiCallback<PokemonDetails>) {
        api.fetchPokemonInfo(id).enqueue(object : Callback<PokemonInfoResponse> {
            override fun onResponse(call: Call<PokemonInfoResponse>, response: Response<PokemonInfoResponse>) {
                val pokemonInfo = response.body()

                if (response.isSuccessful && pokemonInfo != null) {
                    val abilities = pokemonInfo.abilities.map {
                        it.ability.name
                    }

                    val pokemonDetails = PokemonDetails(
                        pokemonInfo.id, pokemonInfo.name, pokemonInfo.imageUrl, abilities
                    )

                    callback.onSuccess(pokemonDetails)
                } else {
                    callback.onError()
                }
            }

            override fun onFailure(call: Call<PokemonInfoResponse>, t: Throwable) {
                callback.onError()
            }
        })
    }
}