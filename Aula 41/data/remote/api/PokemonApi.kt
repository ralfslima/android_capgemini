package br.com.treinamento.moduloconsumoapi1.data.remote.api

import br.com.treinamento.moduloconsumoapi1.data.remote.dto.PokemonDetail
import br.com.treinamento.moduloconsumoapi1.data.remote.dto.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getAllPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): PokemonDetail

}