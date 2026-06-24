package br.com.treinamento.modulojetpackcompose.projeto3

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.treinamento.modulojetpackcompose.projeto3.componentes.ModoCarrossel
import br.com.treinamento.modulojetpackcompose.projeto3.componentes.ModoGrid
import br.com.treinamento.modulojetpackcompose.projeto3.modelos.ItemMenu

@Composable
fun Projeto3() {

    // Lista de opções do menu
    val menu = listOf(
        ItemMenu("Início",    Icons.Filled.Home),
        ItemMenu("Perfil",    Icons.Filled.Person),
        ItemMenu("Favoritos", Icons.Filled.Favorite),
        ItemMenu("Ajustes",   Icons.Filled.Settings),
        ItemMenu("Destaques", Icons.Filled.Star)
    )

    // Estrutura responsiva
    BoxWithConstraints(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
    ) {

        // Largura máxima
        val larguraMaxima = maxWidth <= 500.dp

        // Condicional
        if(larguraMaxima) {
            ModoCarrossel(menu)
        } else {
            ModoGrid(menu)
        }

    }

}