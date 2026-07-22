package br.com.treinamento.modulopersistencia.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.treinamento.modulopersistencia.data.repository.PessoaRepository
import br.com.treinamento.modulopersistencia.model.Pessoa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
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
    fun cadastrar(nome: String, cidade: String, idade: Int) {
        viewModelScope.launch {
            repository.cadastrar(Pessoa(nome = nome, cidade = cidade, idade = idade))
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

// Classe para disponibilizar o repositório para a ViewModel
class PessoaViewModelFactory(private val repository: PessoaRepository): ViewModelProvider.Factory {
    override fun<T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PessoaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PessoaViewModel(repository) as T
        }
        throw IllegalArgumentException("Falha ao disponbilizar o repository")
    }
}










