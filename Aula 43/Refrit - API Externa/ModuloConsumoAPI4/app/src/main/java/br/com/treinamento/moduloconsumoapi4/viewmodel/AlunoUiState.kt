package br.com.treinamento.moduloconsumoapi4.viewmodel

import br.com.treinamento.moduloconsumoapi4.model.Aluno

// AlunoUiState
data class AlunoUiState(
    val codigo: String = "",

    val nome: String = "",

    val nota1: String = "",

    val nota2: String = "",


    val alunos: List<Aluno> = emptyList(),


    val modoEdicao: Boolean = false,


    val codigoEdicao: Int? = null,


    val carregando: Boolean = false,


    val erro: String? = null
)