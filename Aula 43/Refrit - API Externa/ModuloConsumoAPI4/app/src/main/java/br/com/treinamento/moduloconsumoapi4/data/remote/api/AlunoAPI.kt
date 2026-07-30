package br.com.treinamento.moduloconsumoapi4.data.remote.api

import br.com.treinamento.moduloconsumoapi4.data.remote.dto.AlunoDTO
import br.com.treinamento.moduloconsumoapi4.data.remote.dto.AtualizarAlunoDTO
import br.com.treinamento.moduloconsumoapi4.data.remote.dto.NovoAlunoDTO
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

// Endpoints da API
interface AlunoApi {

    @GET("alunos")
    suspend fun listarAlunos(): List<AlunoDTO>

    @GET("alunos/{codigo}")
    suspend fun buscarAluno(
        @Path("codigo") codigo: Int
    ): AlunoDTO

    @POST("alunos")
    suspend fun cadastrarAluno(
        @Body aluno: NovoAlunoDTO
    )

    @PUT("alunos/{codigo}")
    suspend fun atualizarAluno(
        @Path("codigo") codigo: Int,
        @Body aluno: AtualizarAlunoDTO
    )

    @DELETE("alunos/{codigo}")
    suspend fun excluirAluno(
        @Path("codigo") codigo: Int
    )

}