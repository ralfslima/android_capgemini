package br.com.treinamento.modulopersistencia2.data.repository

import br.com.treinamento.modulopersistencia2.data.local.dao.PessoaDao
import br.com.treinamento.modulopersistencia2.data.local.entity.EnderecoEntity
import br.com.treinamento.modulopersistencia2.data.local.entity.PessoaComEnderecosEntity
import br.com.treinamento.modulopersistencia2.data.local.entity.PessoaEntity
import br.com.treinamento.modulopersistencia2.model.Endereco
import br.com.treinamento.modulopersistencia2.model.Pessoa
import br.com.treinamento.modulopersistencia2.model.PessoaComEnderecos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PessoaRepositoryImpl(private val dao: PessoaDao): PessoaRepository {
    override val listarComEnderecos: Flow<List<PessoaComEnderecos>> =
        dao.listarComEnderecos().map { lista -> lista.map { it.toModel() } }

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
    idade = idade
)

private fun Pessoa.toEntity() = PessoaEntity(
    codigo = codigo,
    nome = nome,
    idade = idade
)

// Funções para trabalhar com o relacionamento entre as tabelas/entidades
private fun PessoaComEnderecosEntity.toModel() = PessoaComEnderecos(
    pessoa = pessoa.toModel(),
    enderecos = enderecos.map { it.toModel() }
)

private fun EnderecoEntity.toModel() = Endereco(
    codigo = codigo,
    bairro = bairro,
    logradouro = logradouro,
    numero = numero,
    pessoaCodigo = pessoaCodigo
)