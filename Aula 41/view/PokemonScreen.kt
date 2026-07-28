package br.com.treinamento.moduloconsumoapi1.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.treinamento.moduloconsumoapi1.model.Pokemon
import br.com.treinamento.moduloconsumoapi1.viewmodel.PokemonViewModel
import coil.compose.AsyncImage

@Composable
fun PokemonScreen(viewModel: PokemonViewModel = viewModel()) {

    // Obter a lista de todos os Pokémons da primeira geração
    val pokemons = viewModel.pokemons

    // Estrutura
    Box(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
    ) {
        // Carregamento
        if(viewModel.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize()
            ) {
                items(pokemons) { pokemon ->
                    PokemonCard(pokemon)
                }
            }
        }

    }

}

@Composable
fun PokemonCard(pokemon: Pokemon) {

    // Card
    Card(
        modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
    ) {

        // Coluna
        Column(
            modifier = Modifier.fillMaxWidth().padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagem do Pokémon
            AsyncImage(
                model = pokemon.image,
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )

            // Nome do Pokémon
            Text(pokemon.name)
        }

    }

}