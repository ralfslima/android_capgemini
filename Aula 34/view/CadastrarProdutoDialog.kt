package br.com.treinamento.projetomvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
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

                // Nome da marca
                ExposedDropdownMenuBox(
                    expanded = abrirDropDown,
                    onExpandedChange = { abrirDropDown = !abrirDropDown }
                ) {
                    OutlinedTextField(
                        value = viewModel.obterNomeMarca(marca),
                        onValueChange = {},
                        label = { Text("Marca do produto") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(
                                type = ExposedDropdownMenuAnchorType.PrimaryNotEditable
                            ),
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = abrirDropDown)
                        },
                        readOnly = true
                    )

                    ExposedDropdownMenu(
                        expanded = abrirDropDown,
                        onDismissRequest = { abrirDropDown = false }
                    ) {
                        viewModel.marcas.forEach { obj ->
                            DropdownMenuItem(
                                text = { Text(obj.nome) },
                                onClick = {
                                    viewModel.atualizarMarcaProduto(obj.id)
                                    abrirDropDown = false
                                }
                            )
                        }
                    }
                }


            }
        },
        confirmButton = {
            Button(
                onClick = {
                    viewModel.cadastrarProduto()
                    fecharDialog()
                }
            ) { Text("Cadastrar") }
        },
        dismissButton = {
            Button(
                onClick = {
                    viewModel.limparFormulario()
                    fecharDialog()
                }
            ) { Text("Cancelar") }
        }
    )

}