package br.com.treinamento.moduloconsumoapi4.model

// Data Class de modelo
data class Aluno(
    val codigo: Int,
    val nome: String,
    val nota1: Double,
    val nota2: Double,
    val media: Double,
    val situacao: String
)