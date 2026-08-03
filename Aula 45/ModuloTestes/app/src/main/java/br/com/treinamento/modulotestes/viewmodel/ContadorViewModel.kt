package br.com.treinamento.modulotestes.viewmodel

// Importação da ViewModel
import androidx.lifecycle.ViewModel

// Outras importações
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

// Classe
class ContadorViewModel : ViewModel() {

    // Contador
    var contador by mutableStateOf(0)
        private set  // <- Modifica o contador apenas na classe ContadorViewModel

    // Função para incrementar o contador
    fun incrementar() {
        contador++
    }
}