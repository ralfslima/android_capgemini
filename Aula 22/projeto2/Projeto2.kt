package br.com.treinamento.modulonavegacao.projeto2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.com.treinamento.modulonavegacao.projeto2.rotas.NavGraph

@Composable
fun Projeto2() {

    // Variável NavController
    val navController = rememberNavController()

    // Estrutura
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
    ) {
        NavGraph(navController)
    }

}