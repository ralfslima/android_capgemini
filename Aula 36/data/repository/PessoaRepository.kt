package br.com.treinamento.modulopersistencia.data.repository

import br.com.treinamento.modulopersistencia.model.Pessoa
import kotlinx.coroutines.flow.Flow

interface PessoaRepository {

    val listar: Flow<List<Pessoa>>
    suspend fun cadastrar(pessoa: Pessoa)
    suspend fun editar(pessoa: Pessoa)
    suspend fun remover(pessoa: Pessoa)

}