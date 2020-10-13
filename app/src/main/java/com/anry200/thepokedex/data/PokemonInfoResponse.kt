package com.anry200.thepokedex.data

/**
 * This is detailed information about Pokemon.
 * For far only "Abilities" we are interested in.
 * Just add other fields from api in case if needed.
 *
 * See API description at //https://pokeapi.co/api/v2/pokemon/1/
 */
data class PokemonInfoResponse(
    val id: String,
    val name: String,
    val abilities: List<Ability>
) {
    data class Ability(
        val ability: AbilityPartialInfo,
        val slot: Int
    )

    data class AbilityPartialInfo(
        val name: String,
        val url: String
    )
}

val PokemonInfoResponse.imageUrl: String
    get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"