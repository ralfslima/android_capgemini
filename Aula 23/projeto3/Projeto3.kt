package br.com.treinamento.modulonavegacao.projeto3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.com.treinamento.modulonavegacao.projeto3.rotas.NavGraph

@Composable
fun Projeto3() {

    // NavController
    val navController = rememberNavController()

    // Estrutura
    Column(
        modifier = Modifier.fillMaxSize().safeDrawingPadding()
    ) {
        NavGraph(navController)
    }

}