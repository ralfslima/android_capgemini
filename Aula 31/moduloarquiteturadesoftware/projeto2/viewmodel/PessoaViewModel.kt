package br.com.treinamento.moduloarquiteturadesoftware.projeto2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.treinamento.moduloarquiteturadesoftware.projeto2.model.Pessoa
import br.com.treinamento.moduloarquiteturadesoftware.projeto2.repository.PessoaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PessoaViewModel @Inject constructor(private val pessoaRepository: PessoaRepository): ViewModel() {

    // Estado - Pessoas
    private val _pessoas = MutableStateFlow<List<Pessoa>>(emptyList())
    val pessoas: StateFlow<List<Pessoa>> = _pessoas.asStateFlow()

    // Inicializador - Injeção de dependências
    init {
        viewModelScope.launch {
            _pessoas.value = pessoaRepository.listarPessoas()
        }
    }

}