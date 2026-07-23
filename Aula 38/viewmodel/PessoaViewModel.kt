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

// VERSÃO 2
data class PessoaUiState(
    val codigo: Int = 0,
    val nome: String = "",
    val cidade: String = "",
    val idade: String = "",
    val emEdicao: Boolean = false
)

class PessoaViewModel(private val repository: PessoaRepository): ViewModel() {

    // Estado do formulário, controlado inteiramente pelo ViewModel
    private val _uiState = MutableStateFlow(PessoaUiState())
    val uiState: StateFlow<PessoaUiState> = _uiState

    fun atualizarCampo(transformacao: (PessoaUiState) -> PessoaUiState) {
        _uiState.update(transformacao)
    }

    // Chamada ao clicar num item da lista, pra editar
    fun iniciarEdicao(pessoa: Pessoa) {
        _uiState.value = PessoaUiState(
            codigo = pessoa.codigo,
            nome = pessoa.nome,
            cidade = pessoa.cidade,
            idade = pessoa.idade.toString(),
            emEdicao = true
        )
    }

    // Limpa o formulário (usado após salvar, ou ao cancelar edição)
    fun limparFormulario() {
        _uiState.value = PessoaUiState()
    }

    // Lista de pessoas
    val pessoas: StateFlow<List<Pessoa>> = repository.listar
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    // Decide sozinho se deve inserir ou atualizar
    fun salvar() {
        val estado = _uiState.value
        if (estado.nome.isBlank() || estado.cidade.isBlank()) return // validação simples

        viewModelScope.launch {
            val pessoa = Pessoa(
                codigo = estado.codigo,
                nome = estado.nome,
                cidade = estado.cidade,
                idade = estado.idade.toIntOrNull() ?: 0
            )
            if (estado.emEdicao) {
                repository.editar(pessoa)
            } else {
                repository.cadastrar(pessoa)
            }
            limparFormulario()
        }
    }

    // Função de remoção
    fun remover(pessoa: Pessoa) {
        viewModelScope.launch {
            repository.remover(pessoa)
        }
    }
}



// VERSÃO 1
//class PessoaViewModel(private val repository: PessoaRepository): ViewModel() {
//
//    // Lista de pessoas
//    val pessoas: StateFlow<List<Pessoa>> = repository.listar
//        .stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5000),
//            initialValue = emptyList()
//        )
//
//    // Função de cadastro
//    fun cadastrar(nome: String, cidade: String, idade: Int) {
//        viewModelScope.launch {
//            repository.cadastrar(Pessoa(nome = nome, cidade = cidade, idade = idade))
//        }
//    }
//
//    // Função de edição
//    fun editar(pessoa: Pessoa) {
//        viewModelScope.launch {
//            repository.editar(pessoa)
//        }
//    }
//
//    // Função de remoção
//    fun remover(pessoa: Pessoa) {
//        viewModelScope.launch {
//            repository.remover(pessoa)
//        }
//    }
//}

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










