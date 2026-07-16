package br.com.treinamento.projetomvvm.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import br.com.treinamento.projetomvvm.navigation.Destinos
import br.com.treinamento.projetomvvm.viewmodel.GerenciadorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProdutoScreen(
    navController: NavController,
    viewModel: GerenciadorViewModel
){

    // Referência para exibir ou ocultar o modal
    var mostrarDialog by remember { mutableStateOf(false) }

    // Lista de produtos
    val listaProdutos by viewModel.produtos.collectAsStateWithLifecycle()

    // Scaffold
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Gerenciar Produtos") },
                actions = {
                    IconButton(
                        onClick = { navController.navigate(Destinos.MARCAS) }
                    ) {
                        Icon(Icons.Default.BarChart, null)
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { mostrarDialog = true }
            ) {
                Icon(Icons.Default.Add, null)
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            items(listaProdutos) { produto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("Produto: ${produto.nome}")
                            Text("Marca: ${viewModel.obterNomeMarca(produto.idMarca)}")
                        }

                        IconButton(
                            onClick = { viewModel.removerProduto(produto.id) }
                        ) {
                            Icon(Icons.Default.Delete, null)
                        }
                    }
                }
            }
        }
    }

    // CadastrarProdutoDialog
    if(mostrarDialog) {
        CadastrarProdutoDialog(
            viewModel = viewModel,
            fecharDialog = { mostrarDialog = false }
        )
    }

}







