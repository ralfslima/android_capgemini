package br.com.treinamento.modulonavegacao.projeto4.rotas

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.treinamento.modulonavegacao.projeto4.telas.TelaFavoritos
import br.com.treinamento.modulonavegacao.projeto4.telas.TelaInicio
import br.com.treinamento.modulonavegacao.projeto4.telas.TelaPerfil

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Rotas.INICIO
    ) {
        composable(Rotas.INICIO)    { TelaInicio() }
        composable(Rotas.FAVORITOS) { TelaFavoritos() }
        composable(Rotas.PERFIL)    { TelaPerfil() }
    }

}