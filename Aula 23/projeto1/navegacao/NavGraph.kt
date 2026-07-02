package br.com.treinamento.modulonavegacao.projeto1.navegacao

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.treinamento.modulonavegacao.projeto1.telas.TelaConfiguracao
import br.com.treinamento.modulonavegacao.projeto1.telas.TelaInicio
import br.com.treinamento.modulonavegacao.projeto1.telas.TelaPerfil

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Rotas.INICIO
    ) {
        composable(Rotas.INICIO) { TelaInicio(navController) }
        composable(Rotas.PERFIL) { TelaPerfil(navController) }
        composable(Rotas.CONFIGURACAO) { TelaConfiguracao(navController) }
    }

}







