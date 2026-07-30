package br.com.treinamento.moduloconsumoapi4.data.remote

import br.com.treinamento.moduloconsumoapi4.data.remote.api.AlunoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Configurar acesso a API
object RetrofitInstance {

    private const val BASE_URL = "https://api-01u9.onrender.com/"

    val api: AlunoApi by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(AlunoApi::class.java)

    }

}