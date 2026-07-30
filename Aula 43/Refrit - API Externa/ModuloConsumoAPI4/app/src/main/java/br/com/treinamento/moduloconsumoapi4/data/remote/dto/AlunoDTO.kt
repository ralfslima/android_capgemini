package br.com.treinamento.moduloconsumoapi4.data.remote.dto

import br.com.treinamento.moduloconsumoapi4.model.Aluno

// Data Class de DTO
data class AlunoDTO(
    val codigo: Int,
    val nome: String,
    val nota1: Double,
    val nota2: Double,
    val media: Double,
    val situacao: String
)

// Função toModel, responsável por converter um modelo em um DTO
fun AlunoDTO.toModel() = Aluno(
    codigo,
    nome,
    nota1,
    nota2,
    media,
    situacao
)