package br.com.treinamento.moduloconsumoapi1.data.model

// Data Class para extrair dados de um Pokémon específico
data class PokemonDetail(
    val id: Int,
    val name: String,
    val sprites: Sprites
)

// Data Class para extrair a imagem de um Pokémon
data class Sprites(
    val front_default: String?
)