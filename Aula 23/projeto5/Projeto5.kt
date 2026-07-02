package br.com.treinamento.modulonavegacao.projeto5

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.treinamento.modulonavegacao.projeto5.rotas.NavGraph
import br.com.treinamento.modulonavegacao.projeto5.rotas.Rotas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Projeto5() {

    // NavController
    val navController = rememberNavController()

    // Rota Atual
    val rotaAtual = navController.currentBackStackEntryAsState().value?.destination?.route

    // Scaffold
    Scaffold(
        // TopBar
        topBar = {
            TopAppBar(title = { Text("Meu APP") })
        },

        // BottomBar
        bottomBar = {
            BottomAppBar {
                // Barra de navegação
                NavigationBar() {
                    // Item 1 - Início
                    NavigationBarItem(
                        selected = rotaAtual == Rotas.INICIO,
                        onClick = { navController.navigate(Rotas.INICIO) },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null
                            )
                        },
                        label = { Text("Início") }
                    )

                    // Item 2 - Favoritos
                    NavigationBarItem(
                        selected = rotaAtual == Rotas.FAVORITOS,
                        onClick = { navController.navigate(Rotas.FAVORITOS) },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = null
                            )
                        },
                        label = { Text("Favoritos") }
                    )

                    // Item 3 - Perfil
                    NavigationBarItem(
                        selected = rotaAtual == Rotas.PERFIL,
                        onClick = { navController.navigate(Rotas.PERFIL) },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        },
                        label = { Text("Perfil") }
                    )
                }
            }
        }
    ) {
        espacamento ->
        NavGraph(
            navController = navController,
            modifier = Modifier.padding(espacamento)
        )
    }

}







