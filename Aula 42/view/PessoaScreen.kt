package br.com.treinamento.moduloconsumoapi2.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.treinamento.moduloconsumoapi2.data.model.Pessoa
import br.com.treinamento.moduloconsumoapi2.viewmodel.PessoaViewModel

@Composable
fun PessoaScreen(viewModel: PessoaViewModel = viewModel()) {

    // UiState
    val uiState by viewModel.uiState.collectAsState()

    // Gerenciar o nome e a cidade
    var nome by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }

    // Sempre que o item "em edição" mudar, preenchemos os campos do formulário
    LaunchedEffect(uiState.pessoaEmEdicao) {
        nome = uiState.pessoaEmEdicao?.nome ?: ""
        cidade = uiState.pessoaEmEdicao?.cidade ?: ""
    }

    // Estrutura
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = if (uiState.pessoaEmEdicao == null) "Nova pessoa" else "Editando pessoa",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = cidade,
            onValueChange = { cidade = it },
            label = { Text("Cidade") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Button(
                onClick = {
                    if (nome.isNotBlank() && cidade.isNotBlank()) {
                        viewModel.salvarPessoa(nome, cidade)
                        nome = ""
                        cidade = ""
                    }
                }
            ) {
                Text(if (uiState.pessoaEmEdicao == null) "Adicionar" else "Salvar alterações")
            }

            if (uiState.pessoaEmEdicao != null) {
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedButton(onClick = { viewModel.cancelarEdicao() }) {
                    Text("Cancelar")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (uiState.isLoading) {
            CircularProgressIndicator()
        }

        uiState.errorMessage?.let { mensagem ->
            Text(text = mensagem, color = MaterialTheme.colorScheme.error)
        }

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(uiState.pessoas, key = { it.id }) { pessoa ->
                PessoaItem(
                    pessoa = pessoa,
                    onEditClick = { viewModel.selecionarParaEdicao(pessoa) },
                    onDeleteClick = { viewModel.excluirPessoa(pessoa.id) }
                )
            }
        }
    }
}

@Composable
fun PessoaItem(
    pessoa: Pessoa,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = pessoa.nome, style = MaterialTheme.typography.bodyLarge)
                Text(text = pessoa.cidade, style = MaterialTheme.typography.bodySmall)
            }
            Row {
                IconButton(onClick = onEditClick) {
                    Icon(Icons.Default.Edit, contentDescription = "Editar")
                }
                IconButton(onClick = onDeleteClick) {
                    Icon(Icons.Default.Delete, contentDescription = "Excluir")
                }
            }
        }
    }
}
