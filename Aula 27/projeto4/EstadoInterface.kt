package br.com.treinamento.modulogestaodeestado.projeto4

data class EstadoInterface(
    val nome:   String = "",
    val cidade: String = "",
    val pessoas: List<Pessoa> = emptyList()
)
