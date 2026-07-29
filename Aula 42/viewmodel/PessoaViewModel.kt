package br.com.treinamento.moduloconsumoapi2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.treinamento.moduloconsumoapi2.data.model.Pessoa
import br.com.treinamento.moduloconsumoapi2.data.repository.PessoaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// Representa tudo o que a tela precisa saber sobre o estado atual
data class PessoaUiState(
    val pessoas: List<Pessoa> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val pessoaEmEdicao: Pessoa? = null // null = criando nova; não-null = editando
)

class PessoaViewModel(private val repository: PessoaRepository = PessoaRepository()) : ViewModel() {

    private val _uiState = MutableStateFlow(PessoaUiState())
    val uiState: StateFlow<PessoaUiState> = _uiState.asStateFlow()

    init {
        carregarPessoas()
    }

    fun carregarPessoas() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

            try {
                val lista = repository.getPessoas()
                _uiState.value = _uiState.value.copy(pessoas = lista, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = "Erro ao carregar: ${e.message}"
                )
            }
        }
    }

    fun salvarPessoa(nome: String, cidade: String) {
        viewModelScope.launch {
            try {
                val emEdicao = _uiState.value.pessoaEmEdicao
                if (emEdicao == null) {
                    repository.addPessoa(Pessoa(nome = nome, cidade = cidade))
                } else {
                    repository.updatePessoa(emEdicao.copy(nome = nome, cidade = cidade))
                }
                _uiState.value = _uiState.value.copy(pessoaEmEdicao = null)
                carregarPessoas() // recarrega a lista após salvar
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(errorMessage = "Erro ao salvar: ${e.message}")
            }
        }
    }

    fun selecionarParaEdicao(pessoa: Pessoa) {
        _uiState.value = _uiState.value.copy(pessoaEmEdicao = pessoa)
    }

    fun cancelarEdicao() {
        _uiState.value = _uiState.value.copy(pessoaEmEdicao = null)
    }

    fun excluirPessoa(id: String) {
        viewModelScope.launch {
            try {
                repository.deletePessoa(id)
                carregarPessoas()
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(errorMessage = "Erro ao excluir: ${e.message}")
            }
        }
    }
}
