package br.com.treinamento.projetomvvm.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.treinamento.projetomvvm.view.MarcaScreen
import br.com.treinamento.projetomvvm.view.ProdutoScreen
import br.com.treinamento.projetomvvm.viewmodel.GerenciadorViewModel

@Composable
fun AppNavigation() {

    // NavController
    val navController = rememberNavController()

    // ViewModel
    val viewModel: GerenciadorViewModel = viewModel()

    // NavHost
    NavHost(
        navController = navController,
        startDestination = Destinos.PRODUTOS
    ) {
        composable(Destinos.PRODUTOS) {
            //ProdutoScreen(navController, viewModel)
            ProdutoScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(Destinos.MARCAS) {
            MarcaScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

    }

}