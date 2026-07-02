package br.com.treinamento.modulonavegacao.projeto3.rotas

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import br.com.treinamento.modulonavegacao.projeto3.telas.TelaDadosUsuario
import br.com.treinamento.modulonavegacao.projeto3.telas.TelaFormularioUsuario

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = FormularioUsuario
    ) {
        composable<FormularioUsuario> {
            TelaFormularioUsuario(navController)
        }

        composable<DadosUsuario> { backStackEntry ->
            val dados = backStackEntry.toRoute<DadosUsuario>()
            TelaDadosUsuario(navController, dados)
        }
    }

}