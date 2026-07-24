package br.com.treinamento.modulopersistencia2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import br.com.treinamento.modulopersistencia2.data.repository.PessoaRepository
import br.com.treinamento.modulopersistencia2.model.PessoaComEnderecos
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class PessoaComEnderecosViewModel(repository: PessoaRepository) : ViewModel() {

    val pessoasComEnderecos: StateFlow<List<PessoaComEnderecos>> = repository.listarComEnderecos
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}

class PessoaComEnderecosViewModelFactory(
    private val repository: PessoaRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PessoaComEnderecosViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PessoaComEnderecosViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido")
    }
}