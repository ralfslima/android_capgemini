package br.com.treinamento.modulopersistencia2.data.repository

import br.com.treinamento.modulopersistencia2.model.Pessoa
import br.com.treinamento.modulopersistencia2.model.PessoaComEnderecos
import kotlinx.coroutines.flow.Flow

interface PessoaRepository {

    val listarComEnderecos: Flow<List<PessoaComEnderecos>>
    val listar: Flow<List<Pessoa>>
    suspend fun cadastrar(pessoa: Pessoa)
    suspend fun editar(pessoa: Pessoa)
    suspend fun remover(pessoa: Pessoa)

}