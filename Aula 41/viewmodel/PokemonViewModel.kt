package br.com.treinamento.moduloconsumoapi1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.treinamento.moduloconsumoapi1.data.remote.RetrofitInstance
import br.com.treinamento.moduloconsumoapi1.data.remote.service.PokemonService
import br.com.treinamento.moduloconsumoapi1.data.repository.PokemonRepository
import br.com.treinamento.moduloconsumoapi1.model.Pokemon
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    // Referência de Serviço
    private val _service = PokemonService(RetrofitInstance.api)

    // Referência de Repositório
    private val _repository = PokemonRepository(_service)

    // Lista de Pokémons
    var pokemons by mutableStateOf<List<Pokemon>>(emptyList())

    // Variável de carregamento
    var isLoading by mutableStateOf<Boolean>(false)

    // Ao carregar o projeto
    init {
        loadPokemons()
    }

    // Função para obter uma lista de Pokémons
    private fun loadPokemons() {

        // Executar uma ação assíncrona
        viewModelScope.launch {

            // Tentativa
            try {
                isLoading = true
                pokemons = _repository.getAllPokemons()
            } finally {
                isLoading = false
            }

        }

    }

}