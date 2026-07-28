package br.com.treinamento.moduloconsumoapi1.data.remote

import br.com.treinamento.moduloconsumoapi1.data.remote.api.PokemonApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // URL da API
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    // Acessar a URL e manipular as informações em formato JSON
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()

    // Inicializar Retrofit
    val api: PokemonApi = retrofit.create(PokemonApi::class.java)
}