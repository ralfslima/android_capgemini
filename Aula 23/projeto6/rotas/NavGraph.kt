package br.com.treinamento.modulonavegacao.projeto6.rotas

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.treinamento.modulonavegacao.projeto6.telas.TelaFavoritos
import br.com.treinamento.modulonavegacao.projeto6.telas.TelaInicio
import br.com.treinamento.modulonavegacao.projeto6.telas.TelaPerfil

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier) {

    NavHost(
        navController = navController,
        startDestination = Rotas.INICIO,
        modifier = modifier
    ) {
        composable(Rotas.INICIO)    { TelaInicio() }
        composable(Rotas.FAVORITOS) { TelaFavoritos() }
        composable(Rotas.PERFIL)    { TelaPerfil() }
    }

}