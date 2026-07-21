package br.com.treinamento.modulopersistencia.data.repository

import br.com.treinamento.modulopersistencia.data.local.PessoaDao
import br.com.treinamento.modulopersistencia.data.local.PessoaEntity
import br.com.treinamento.modulopersistencia.model.Pessoa
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PessoaRepositoryImpl(private val dao: PessoaDao): PessoaRepository {
    override val listar: Flow<List<Pessoa>> = dao.listar().map { lista -> lista.map{ it.toModel() } }

    override suspend fun cadastrar(pessoa: Pessoa) {
        dao.cadastrar(pessoa.toEntity())
    }

    override suspend fun editar(pessoa: Pessoa) {
        dao.editar(pessoa.toEntity())
    }

    override suspend fun remover(pessoa: Pessoa) {
        dao.remover(pessoa.toEntity())
    }
}

// Funções para realizar a conversão de classes - Pessoa | PessoaEntidade
private fun PessoaEntity.toModel() = Pessoa(
    codigo = codigo,
    nome   = nome,
    cidade = cidade
)

private fun Pessoa.toEntity() = PessoaEntity(
    codigo = codigo,
    nome = nome,
    cidade = cidade
)