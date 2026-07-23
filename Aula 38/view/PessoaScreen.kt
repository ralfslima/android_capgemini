package br.com.treinamento.modulopersistencia.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import br.com.treinamento.modulopersistencia.viewmodel.PessoaViewModel
import br.com.treinamento.modulopersistencia.model.Pessoa

// ***** IMPORTAÇÕES
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.Edit
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp



// VERSÃO 2
@Composable
fun PessoaScreen(viewModel: PessoaViewModel) {

    // Lista de pessoas
    val listaPessoas by viewModel.pessoas.collectAsState()

    // Obter os dados informados pelo usuário e verificar se haverá uma ação de cadastro ou edição
    val uiState by viewModel.uiState.collectAsState()

    // Gerenciador de foco
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    // Coluna
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título dinâmico baseado no modo atual
        Text(
            text =  if (uiState.emEdicao) "Editar Pessoa" else "Cadastrar Pessoa",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        // Espaçamento
        Spacer(Modifier.height(16.dp))

        // Campo nome
        OutlinedTextField(
            value = uiState.nome,
            onValueChange = { valor -> viewModel.atualizarCampo { it.copy(nome = valor) } },
            label = { Text("Nome") },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
        )

        // Espaçamento
        Spacer(Modifier.height(8.dp))

        // Campo cidade
        OutlinedTextField(
            value = uiState.cidade,
            onValueChange = { valor -> viewModel.atualizarCampo { it.copy(cidade = valor) } },
            label = { Text("Cidade") },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
        )

        // Espaçamento
        Spacer(Modifier.height(8.dp))

        // Campo idade
        OutlinedTextField(
            value = uiState.idade,
            onValueChange = { valor -> viewModel.atualizarCampo { it.copy(idade = valor.filter { c -> c.isDigit() }) } },
            label = { Text("Idade") },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
        )

        // Espaçamento
        Spacer(Modifier.height(12.dp))

        // Linha para exibir os botões - cadastrar, editar e cancelar
        Row {
            Button(
                onClick = {
                    viewModel.salvar()
                    focusManager.clearFocus()
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(if (uiState.emEdicao) "Editar" else "Cadastrar")
            }

            if (uiState.emEdicao) {
                Spacer(Modifier.width(8.dp))
                OutlinedButton(
                    onClick = {
                        viewModel.limparFormulario()
                        focusManager.clearFocus()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Cancelar")
                }
            }
        }

        // Espaçamento
        Spacer(Modifier.height(24.dp))

        // Listagem de pessoas
        LazyColumn {
            items(listaPessoas) { pessoa ->
                PessoaCard(
                    pessoa = pessoa,
                    onClick = {
                        viewModel.iniciarEdicao(pessoa)
                        focusManager.clearFocus()
                    },
                    onDelete = {
                        viewModel.remover(pessoa)
                        focusManager.clearFocus()
                    }
                )
            }
        }
    }
}

@Composable
fun PessoaCard(pessoa: Pessoa, onClick: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Código: ${pessoa.codigo}", style = MaterialTheme.typography.labelSmall)
                Text(pessoa.nome, style = MaterialTheme.typography.bodyLarge)
                Text("${pessoa.cidade} • ${pessoa.idade} anos", style = MaterialTheme.typography.bodySmall)
            }
            Row {
                IconButton(onClick = onClick) {
                    Icon(Icons.Default.Edit, contentDescription = "Editar")
                }
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "Excluir")
                }
            }
        }
    }
}

// VERSÃO 1
//@Composable
//fun PessoaScreen(viewModel: PessoaViewModel) {
//
//    // Lista de pessoas
//    val listaPessoas by viewModel.pessoas.collectAsState()
//
//    // Obter os dados informados pelo usuário
//    var nome by remember { mutableStateOf("") }
//    var cidade by remember { mutableStateOf("") }
//    var idade by remember { mutableStateOf("") }
//
//    // Rastreia qual pessoa está sendo editada (null significa que estamos criando uma nova)
//    var pessoaEmEdicao by remember { mutableStateOf<Pessoa?>(null) }
//
//    // Gerenciador de foco
//    val focusManager = LocalFocusManager.current
//    val focusRequester = remember { FocusRequester() }
//
//    // Coluna
//    Column(
//        modifier = Modifier
//            .safeDrawingPadding()
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        // Título dinâmico baseado no modo atual
//        Text(
//            text = if (pessoaEmEdicao == null) "Cadastrar Pessoa" else "Editar Pessoa",
//            style = MaterialTheme.typography.titleLarge,
//            modifier = Modifier.fillMaxWidth(),
//            textAlign = TextAlign.Center
//        )
//
//        // Espaçamento
//        Spacer(Modifier.height(16.dp))
//
//        // Campo nome
//        OutlinedTextField(
//            value = nome,
//            onValueChange = { nome = it },
//            label = { Text("Nome") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .focusRequester(focusRequester)
//        )
//
//        // Espaçamento
//        Spacer(Modifier.height(8.dp))
//
//        // Campo cidade
//        OutlinedTextField(
//            value = cidade,
//            onValueChange = { cidade = it },
//            label = { Text("Cidade") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .focusRequester(focusRequester)
//        )
//
//        // Espaçamento
//        Spacer(Modifier.height(8.dp))
//
//        // Campo idade
//        OutlinedTextField(
//            value = idade,
//            onValueChange = { idade = it },
//            label = { Text("Idade") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .focusRequester(focusRequester)
//        )
//
//        // Espaçamento
//        Spacer(Modifier.height(12.dp))
//
//        // Linha para exibir os botões - cadastrar, editar e cancelar
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//
//            // Condicional para habilitar o botão cancelar
//            if (pessoaEmEdicao != null) {
//                OutlinedButton(
//                    onClick = {
//                        focusManager.clearFocus()
//                        pessoaEmEdicao = null
//                        nome = ""
//                        cidade = ""
//                        idade = ""
//                    },
//                    modifier = Modifier.weight(1f)
//                ) {
//                    Text("Cancelar")
//                }
//            }
//
//            // Botões de cadastro e edição
//            Button(
//                onClick = {
//                    val atual = pessoaEmEdicao
//
//                    if (atual == null) {
//                        viewModel.cadastrar(nome, cidade, idade.toIntOrNull() ?: 0)
//                    } else {
//                        viewModel.editar(atual.copy(nome = nome, cidade = cidade, idade = idade.toIntOrNull() ?: 0))
//                        pessoaEmEdicao = null
//                    }
//
//                    focusManager.clearFocus()
//                    nome = ""
//                    cidade = ""
//                    idade = ""
//
//                },
//                modifier = Modifier.weight(1f)
//            ) {
//                // Texto do botão muda dependendo do contexto
//                Text(if (pessoaEmEdicao == null) "Cadastrar" else "Editar")
//            }
//        }
//
//        // Espaçamento
//        Spacer(Modifier.height(24.dp))
//
//        // Listagem de pessoas
//        LazyColumn {
//            // Estrutura de repetição
//            items(listaPessoas) { pessoa ->
//                // Componente para gerar o card
//                PessoaCard(
//                    pessoa = pessoa,
//                    aoEditar = {
//                        focusManager.clearFocus()
//                        pessoaEmEdicao = pessoa
//                        nome = pessoa.nome
//                        cidade = pessoa.cidade
//                        idade = pessoa.idade.toString()
//                    },
//                    aoRemover = {
//                        // Se deletar a pessoa que estava sendo editada, limpa o formulário
//                        if (pessoaEmEdicao?.codigo == pessoa.codigo) {
//                            focusManager.clearFocus()
//                            pessoaEmEdicao = null
//                            nome = ""
//                            cidade = ""
//                            idade = ""
//                        }
//                        viewModel.remover(pessoa)
//                    }
//                )
//            }
//        }
//    }
//}
//
//
//
//@Composable
//fun PessoaCard(
//    pessoa: Pessoa,
//    aoEditar: () -> Unit,
//    aoRemover: () -> Unit
//) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 4.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(12.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Column(modifier = Modifier.weight(1f)) {
//                Text("Código: ${pessoa.codigo}", style = MaterialTheme.typography.labelSmall)
//                Text(pessoa.nome, style = MaterialTheme.typography.bodyLarge)
//                Text(pessoa.cidade, style = MaterialTheme.typography.bodySmall)
//            }
//
//            // Agrupamento dos botões de ação à direita
//            Row {
//                IconButton(onClick = aoEditar) {
//                    Icon(Icons.Default.Edit, contentDescription = "Editar")
//                }
//                IconButton(onClick = aoRemover) {
//                    Icon(Icons.Default.Delete, contentDescription = "Excluir")
//                }
//            }
//        }
//    }
//}



