package br.com.treinamento.moduloarquiteturadesoftware.projeto2.repository

import br.com.treinamento.moduloarquiteturadesoftware.projeto2.model.Pessoa

interface PessoaRepository {
    fun listarPessoas(): List<Pessoa>
}