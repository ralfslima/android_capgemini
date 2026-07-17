package br.com.treinamento.projetomvvm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import br.com.treinamento.projetomvvm.model.Marca
import br.com.treinamento.projetomvvm.model.Produto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GerenciadorViewModel: ViewModel() {

    // StateFlow - Produtos
    //private val _produtos = mutableStateListOf<Produto>()
    //val produtos: List<Produto> = _produtos
    private val _produtos = MutableStateFlow<List<Produto>>(emptyList())
    val produtos: StateFlow<List<Produto>> = _produtos.asStateFlow()

    // Lista de marcas
    val marcas = listOf(
        Marca(1, "Samsung"),
        Marca(2, "Apple"),
        Marca(3, "Motorola"),
        Marca(4, "Xiaomi"),
    )

    // Referências para manipular os elementos da UI
    var nomeProduto  by mutableStateOf("")
    var marcaProduto by mutableStateOf(1)

    // Gerador de IDs
    private var idProduto = 1

    // Função para obter o nome do produto
    fun atualizarNomeProduto(valor: String) {
        nomeProduto = valor
    }

    // Função para obter a marca do produto
    fun atualizarMarcaProduto(valor: Int) {
       marcaProduto = valor
    }

    // Função para limpar o formulário
    fun limparFormulario() {
        nomeProduto = ""
        marcaProduto = 1
    }

    // Função para cadastrar produtos
    fun cadastrarProduto() {

        val novoProduto = Produto(
            id = idProduto++,
            nome = nomeProduto,
            idMarca = marcaProduto
        )

        //_produtos.add(novoProduto) <- Sem o StateFlow
        _produtos.update { listaAtual -> listaAtual + novoProduto }

        limparFormulario()
    }

    // Função para remover produtos
    fun removerProduto(id: Int) {
        _produtos.update { listaAtual ->
            listaAtual.filter { produto -> produto.id != id }
        }
    }

    // Função para receber o id da marca e retornar o nome
    fun obterNomeMarca(idMarca: Int): String {
        return marcas.find { it.id == idMarca }?.nome ?: "Marca desconhecida"
    }

    // Função para retornar a quantidade de produtos por marca
    fun quantidadeProdutosPorMarca(idMarca: Int): Int {
        return _produtos.value.count { it.idMarca == idMarca }
    }

    // Função para retornar a quantidade total de produtos
    fun quantidadeTotalProdutos(): Int {
        return _produtos.value.size
    }

}