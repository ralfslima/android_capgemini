package br.com.treinamento.moduloconsumoapi4.data.repository

import br.com.treinamento.moduloconsumoapi4.data.remote.RetrofitInstance
import br.com.treinamento.moduloconsumoapi4.data.remote.dto.AlunoDTO
import br.com.treinamento.moduloconsumoapi4.data.remote.dto.AtualizarAlunoDTO
import br.com.treinamento.moduloconsumoapi4.data.remote.dto.NovoAlunoDTO
import br.com.treinamento.moduloconsumoapi4.data.remote.dto.toModel
import br.com.treinamento.moduloconsumoapi4.model.Aluno

// Repositório, contendo as regras de cada ação da API (você poderia criar uma camada de serviços, assim deixaria ainda mais organizado)
class AlunoRepository {

    private val api = RetrofitInstance.api

    suspend fun listarAlunos(): List<Aluno> {
        return api
            .listarAlunos()
            .map { it.toModel() }
    }

    suspend fun buscarAluno(codigo: Int): Aluno {
        return api
            .buscarAluno(codigo)
            .toModel()
    }

    suspend fun cadastrarAluno(aluno: NovoAlunoDTO) {
        api.cadastrarAluno(aluno)
    }

    suspend fun atualizarAluno(
        codigo: Int,
        aluno: AtualizarAlunoDTO
    ) {
        api.atualizarAluno(codigo, aluno)
    }

    suspend fun excluirAluno(codigo: Int) {
        api.excluirAluno(codigo)
    }

}