package com.anry200.thepokedex.domain

/**
 * Pokemon Details
 * Additional information about pokemon, added only abilities so far
 * see https://pokeapi.co/api/v2/pokemon/1
 * @param abilities - pokemon ability names
 */
class PokemonDetails(val id: String, val name: String,  val imageUrl: String, val abilities: List<String>)