package br.com.treinamento.moduloconsumoapi1.data.remote.service

import br.com.treinamento.moduloconsumoapi1.data.remote.api.PokemonApi
import br.com.treinamento.moduloconsumoapi1.model.Pokemon

class PokemonService(private val api: PokemonApi) {

    suspend fun getAllPokemons(): List<Pokemon>{

        // Obter a lista dos 151 Pokémons
        val retorno = api.getAllPokemons(limit = 151, offset = 0)

        // Gerar a lista que será utilizada na View
        return retorno.results.map {

            // Criar DTO (para extrair as informações de cada Pokémon)
            val dto = api.getPokemon(it.name)

            // Gerar um objeto do tipo Pokémon
            Pokemon(
                id    = dto.id,
                name  = dto.name,
                image = dto.sprites.frontDefault
            )

        }

    }



}