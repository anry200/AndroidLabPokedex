package com.anry200.thepokedex

data class Pokemon(val id: String, val name: String,  val imageUrl: String)


//https://pokeapi.co/
//https://bulbapedia.bulbagarden.net/wiki/Bulbasaur_(Pok%C3%A9mon)
val pokemonList = listOf(
    Pokemon("1","Bulbasaur", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
    Pokemon("4","Charmander", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"),
    Pokemon("18","Pidgeot", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png"),
    Pokemon("25","Pikachu", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"),
    Pokemon("54","Psyduck", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/54.png")
)