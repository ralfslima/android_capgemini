package br.com.treinamento.moduloarquiteturadesoftware.projeto2.repository

import br.com.treinamento.moduloarquiteturadesoftware.projeto2.model.Pessoa
import javax.inject.Inject

class PessoaRepositoryImpl @Inject constructor(): PessoaRepository {

    override fun listarPessoas(): List<Pessoa> = listOf(
        Pessoa("Alice",    28, "Curitiba"),
        Pessoa("Bianca",   22, "São Paulo"),
        Pessoa("Henrique", 37, "Porto Alegre"),
        Pessoa("Marcela",  34, "Maringá"),
        Pessoa("Paulo",    21, "Campinas"),
        Pessoa("Robson",   43, "Rio de Janeiro"),
        Pessoa("Tatiana",  25, "Salvador"),
        Pessoa("Viviane",  29, "Manaus"),
    )

}