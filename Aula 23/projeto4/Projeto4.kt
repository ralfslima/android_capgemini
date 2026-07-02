package br.com.treinamento.modulonavegacao.projeto4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.treinamento.modulonavegacao.projeto4.rotas.NavGraph
import br.com.treinamento.modulonavegacao.projeto4.rotas.Rotas

@Composable
fun Projeto4() {

    // NavController
    val navController = rememberNavController()

    // Obter o nome da rota atual
    val rotaAtual = navController.currentBackStackEntryAsState().value?.destination?.route

    // Estrutura
    Column(
        modifier = Modifier.fillMaxSize().safeDrawingPadding()
    ) {
        // Exibição das telas/conteúdos
        Column(modifier = Modifier.weight(1f)) {
            NavGraph(navController)
        }

        // Botões/links
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(Rotas.INICIO) { launchSingleTop = true } },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (rotaAtual == Rotas.INICIO) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )

                    Text("Início")
                }

            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(Rotas.FAVORITOS) { launchSingleTop = true } },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (rotaAtual == Rotas.FAVORITOS) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null
                    )

                    Text("Favoritos")
                }
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = { navController.navigate(Rotas.PERFIL) { launchSingleTop = true } },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (rotaAtual == Rotas.PERFIL) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )

                    Text("Perfil")
                }
            }
        }
    }

}







