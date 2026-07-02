package br.com.treinamento.modulonavegacao.projeto6

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.treinamento.modulonavegacao.projeto6.rotas.NavGraph
import br.com.treinamento.modulonavegacao.projeto6.rotas.Rotas
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Projeto6() {

    // NavController
    val navController = rememberNavController()

    // Rota Atual
    val rotaAtual = navController.currentBackStackEntryAsState().value?.destination?.route

    // Estado - Aberto ou Fechado
    val estadoDrawer = rememberDrawerState(initialValue = DrawerValue.Closed)

    // Escopo para controlar o estado
    val escopo = rememberCoroutineScope()

    // ModalNavigationDrawer
    ModalNavigationDrawer(
        drawerState = estadoDrawer,
        drawerContent = {
            ModalDrawerSheet() {
                Column(
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text("Meu App")

                    Spacer(modifier = Modifier.height(15.dp))

                    NavigationDrawerItem(
                        label = { Text("Início") },
                        selected = rotaAtual == Rotas.INICIO,
                        onClick = {
                            navController.navigate(Rotas.INICIO)
                            escopo.launch { estadoDrawer.close() }
                        },
                        icon = {
                            Icon(
                                Icons.Default.Home,
                                contentDescription = null
                            )
                        }
                    )

                    NavigationDrawerItem(
                        label = { Text("Favoritos") },
                        selected = rotaAtual == Rotas.FAVORITOS,
                        onClick = {
                            navController.navigate(Rotas.FAVORITOS)
                            escopo.launch { estadoDrawer.close() }
                        },
                        icon = {
                            Icon(
                                Icons.Default.Favorite,
                                contentDescription = null
                            )
                        }
                    )

                    NavigationDrawerItem(
                        label = { Text("Perfil") },
                        selected = rotaAtual == Rotas.PERFIL,
                        onClick = {
                            navController.navigate(Rotas.PERFIL)
                            escopo.launch { estadoDrawer.close() }
                        },
                        icon = {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = null
                            )
                        }
                    )
                }
            }
        }
    ) {
        // Scaffold
        Scaffold(
            // TopBar
            topBar = {
                TopAppBar(
                    title = { Text("Meu APP") },
                    navigationIcon = {
                        IconButton(
                            onClick = { escopo.launch { estadoDrawer.open() } }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        ) {
                espacamento ->
            NavGraph(
                navController = navController,
                modifier = Modifier.padding(espacamento)
            )
        }
    }

}







