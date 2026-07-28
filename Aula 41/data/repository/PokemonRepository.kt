package br.com.treinamento.moduloconsumoapi1.data.repository

import br.com.treinamento.moduloconsumoapi1.data.remote.service.PokemonService
import br.com.treinamento.moduloconsumoapi1.model.Pokemon

class PokemonRepository(private val service: PokemonService) {

    // Função para retornar uma lista de Pokémons
    suspend fun getAllPokemons(): List<Pokemon> {
        return service.getAllPokemons()
    }

}