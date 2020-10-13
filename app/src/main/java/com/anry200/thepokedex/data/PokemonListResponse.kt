package com.anry200.thepokedex.data

import androidx.core.net.toUri

//https://pokeapi.co/api/v2/pokemon/
data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonPartialInfo>
)

/**
 * Pokemon "name" and "id" are equal for service, so "bulbasaur" as a name and "1" as an id can be used
 */
data class PokemonPartialInfo(
    val name: String,
    val url: String
)

/**
 * Extract pokemon id from url
 */
val PokemonPartialInfo.id: String //It can be replaced by fun PokemonPartialInfo.getId(): String = url.toUri().lastPathSegment ?: ""
    get() = url.toUri().lastPathSegment ?: ""

/**
 * Build image url using pattern with pokemon id.
 * Pokemon "name" can not be used here, only id
 */
val PokemonPartialInfo.imageUrl: String
    get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"