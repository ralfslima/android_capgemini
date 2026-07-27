package br.com.treinamento.moduloconsumoapi1.data.remote.dto

// Data Class para extrair todos os Pokémons
data class PokemonListResponse(
    val results: List<PokemonResult>
)

// Data Class para extrair dados de um Pokémon específico
data class PokemonResult(
    val name: String,
    val url: String
)