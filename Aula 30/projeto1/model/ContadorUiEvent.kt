package br.com.treinamento.moduloarquiteturadesoftware.projeto1.model

sealed interface ContadorUiEvent {
    data class MostrarSnackBar(val mensagem: String): ContadorUiEvent
}
