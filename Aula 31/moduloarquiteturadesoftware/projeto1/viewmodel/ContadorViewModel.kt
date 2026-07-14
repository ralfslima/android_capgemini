package br.com.treinamento.moduloarquiteturadesoftware.projeto1.viewmodel

import androidx.lifecycle.ViewModel
import br.com.treinamento.moduloarquiteturadesoftware.projeto1.model.ContadorUiEvent
import br.com.treinamento.moduloarquiteturadesoftware.projeto1.model.ContadorUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update

class ContadorViewModel: ViewModel() {

    // Estado
    private val _uiState = MutableStateFlow(ContadorUiState())
    val uiState: StateFlow<ContadorUiState> = _uiState.asStateFlow()

    // Evento
    private val _uiEvent = Channel<ContadorUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    // Função para incrementar o contador
    fun incrementar() {
        _uiState.update { estadoAtual ->
            estadoAtual.copy(contador = estadoAtual.contador + 1)
        }

        _uiEvent.trySend(ContadorUiEvent.MostrarSnackBar("Valor incrementado."))
    }

    // Função para decrementar o contador
    fun decrementar() {
        _uiState.update { estadoAtual ->
            estadoAtual.copy(contador = estadoAtual.contador - 1)
        }

        _uiEvent.trySend(ContadorUiEvent.MostrarSnackBar("Valor decrementado."))
    }

}







