package br.com.treinamento.moduloconsumoapi1.data.remote.dto

import com.google.gson.annotations.SerializedName

// Data Class para extrair dados de um Pokémon específico
data class PokemonDetail(
    val id: Int,
    val name: String,
    val sprites: Sprites
)

// Data Class para extrair a imagem de um Pokémon
data class Sprites(
    @SerializedName("front_default")
    val frontDefault: String?
)