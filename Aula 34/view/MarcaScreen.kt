package br.com.treinamento.projetomvvm.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.treinamento.projetomvvm.viewmodel.GerenciadorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarcaScreen(
    navController: NavController,
    viewModel: GerenciadorViewModel
) {
    // Scaffold
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resumo - Marcas") },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(Icons.Default.ArrowBackIosNew, null)
                    }
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            items(viewModel.marcas) { marca ->

                // Obter a quantidade de produtos por marca
                val qtdProdutosPorMarca = viewModel.quantidadeProdutosPorMarca(marca.id)

                // Card
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Text(marca.nome)

                        Spacer(modifier = Modifier.height(10.dp))

                        Text("Quantidade de produtos: $qtdProdutosPorMarca")
                    }
                }

            }

            item {
                Text(
                    text = "Quantidade total de produtos: ${viewModel.quantidadeTotalProdutos()}",
                    modifier = Modifier.padding(10.dp),
                    fontSize = 18.sp
                )
            }

        }

    }
}







