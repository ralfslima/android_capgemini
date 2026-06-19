package br.com.treinamento.modulojetpackcompose.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
LazyColumn -> Alinhamento vertical
LazyRow    -> Alinhamento horizontal
*/

@Composable
fun Componente04_LazyColumn(nomes: List<String>) {

    LazyColumn(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize(),
        contentPadding = PaddingValues(all = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        items(nomes) { nome ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = nome,
                    Modifier.padding(all = 10.dp)
                )
            }
        }

    }

}











