package br.com.treinamento.moduloconsumoapi2.data.model

import com.google.firebase.firestore.DocumentId

data class Pessoa(
    @DocumentId
    val id: String = "",
    val nome: String = "",
    val cidade: String = ""
)
