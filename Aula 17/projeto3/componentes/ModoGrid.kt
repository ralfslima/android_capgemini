package br.com.treinamento.modulojetpackcompose.projeto3.componentes

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.treinamento.modulojetpackcompose.projeto3.modelos.ItemMenu

@Composable
fun ModoGrid(menu: List<ItemMenu>) {

    // Estrutura do Grid
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        // Laço de repetição
        items(menu) { itemMenu ->
            CardGrid(itemMenu)
        }
    }

}

@Composable
fun CardGrid(itemMenu: ItemMenu) {

    // Card
    Card(
        modifier = Modifier.height(100.dp),
        colors = CardColors(
            containerColor = Color(0xFF24F2B8),
            contentColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFF24F2B8),
            disabledContentColor = Color(0xFFFFFFFF)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        // Coluna
        Column(
            modifier = Modifier.fillMaxSize().padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Icon(
                imageVector = itemMenu.icone,
                contentDescription = itemMenu.texto,
                modifier = Modifier.size(50.dp)
            )

            Text(itemMenu.texto)

        }// Coluna
    }// Card

}







