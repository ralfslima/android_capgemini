package br.com.treinamento.modulonavegacao.projeto3.rotas

import kotlinx.serialization.Serializable

@Serializable
object FormularioUsuario  // <- Rota sem parâmetro

@Serializable
data class DadosUsuario( // <- Rota com parâmetro (objeto)
    val nome: String,
    val idade: Int,
    val cidade: String
)
