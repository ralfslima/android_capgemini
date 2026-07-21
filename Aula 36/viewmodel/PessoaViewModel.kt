package br.com.treinamento.modulopersistencia.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.treinamento.modulopersistencia.data.repository.PessoaRepository
import br.com.treinamento.modulopersistencia.model.Pessoa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PessoaViewModel(private val repository: PessoaRepository): ViewModel() {

    // Lista de pessoas
    val pessoas: StateFlow<List<Pessoa>> = repository.listar
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    // Função de cadastro
    fun cadastrar(nome: String, cidade: String) {
        viewModelScope.launch {
            repository.cadastrar(Pessoa(nome = nome, cidade = cidade))
        }
    }

    // Função de edição
    fun editar(pessoa: Pessoa) {
        viewModelScope.launch {
            repository.editar(pessoa)
        }
    }

    // Função de remoção
    fun remover(pessoa: Pessoa) {
        viewModelScope.launch {
            repository.remover(pessoa)
        }
    }
}