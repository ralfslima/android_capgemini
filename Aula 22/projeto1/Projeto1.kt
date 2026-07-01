package br.com.treinamento.modulonavegacao.projeto1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.com.treinamento.modulonavegacao.projeto1.navegacao.NavGraph

@Composable
fun Projeto1() {

    // Criar NavController
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






