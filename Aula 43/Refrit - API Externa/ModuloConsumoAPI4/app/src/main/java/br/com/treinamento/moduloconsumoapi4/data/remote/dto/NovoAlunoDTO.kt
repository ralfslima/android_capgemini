package br.com.treinamento.moduloconsumoapi4.data.remote.dto

// Data Class DTO para cadastrar alunos
data class NovoAlunoDTO(
    val codigo: Int,
    val nome: String,
    val nota1: Double,
    val nota2: Double
)