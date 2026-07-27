package br.com.treinamento.moduloconsumoapi1.data.model

// Data Class para extrair todos os Pokémons
data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResponse>
)

// Data Class para extrair dados de um Pokémon específico
data class PokemonResponse(
    val name: String,
    val url: String
)