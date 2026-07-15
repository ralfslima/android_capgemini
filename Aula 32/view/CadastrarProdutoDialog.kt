package br.com.treinamento.projetomvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.treinamento.projetomvvm.viewmodel.GerenciadorViewModel

@Composable
fun CadastrarProdutoDialog(
    viewModel: GerenciadorViewModel,
    fecharDialog: () -> Unit
) {

    // Obter os estados na ViewModel (Nome e Marca)
    val nome = viewModel.nomeProduto
    val marca = viewModel.marcaProduto

    // Dropdown - Aberto/Fechado
    var abrirDropDown by remember { mutableStateOf(false) }

    // AlertDialog
    AlertDialog(
        onDismissRequest = {
            viewModel.limparFormulario()
            fecharDialog()
        },
        title = { Text("Cadastro de Produtos") },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                // Nome do produto
                OutlinedTextField(
                    value = nome,
                    onValueChange = { viewModel.atualizarNomeProduto(it) },
                    label = { Text("Nome do produto") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {},
        dismissButton = {}
    )

}