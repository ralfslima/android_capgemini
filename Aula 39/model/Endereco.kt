package br.com.treinamento.modulopersistencia2.model

data class Endereco(
    val codigo: Int = 0,
    val bairro: String,
    val logradouro: String,
    val numero: String,
    val pessoaCodigo: Int
)

