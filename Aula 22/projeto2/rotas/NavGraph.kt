package br.com.treinamento.modulonavegacao.projeto2.rotas

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.treinamento.modulonavegacao.projeto2.telas.FormularioSoma
import br.com.treinamento.modulonavegacao.projeto2.telas.RetornoSoma

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Rotas.FORMULARIO_SOMA
    ) {
        composable(Rotas.FORMULARIO_SOMA) { FormularioSoma(navController) }

        composable("${Rotas.RETORNO_SOMA}?numero1={n1}&numero2={n2}") {
            RetornoSoma(navController)
        }

    }

}