package br.com.treinamento.modulopersistencia2.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.treinamento.modulopersistencia2.model.PessoaComEnderecos
import br.com.treinamento.modulopersistencia2.viewmodel.PessoaComEnderecosViewModel

@Composable
fun PrincipalScreen(viewModel: PessoaComEnderecosViewModel) {
    val lista by viewModel.pessoasComEnderecos.collectAsState()

    LazyColumn(
        modifier = Modifier.safeDrawingPadding().fillMaxSize().padding(16.dp)
    ) {
        item {
            Text(
                text = "Relacionamento entre entidades",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(16.dp))
        }
        items(lista, key = { it.pessoa.codigo }) { item ->
            PessoaAccordionItem(item)
            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
fun PessoaAccordionItem(item: PessoaComEnderecos) {
    var expandido by remember { mutableStateOf(false) }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column {
            // Cabeçalho — sempre visível, clicável para expandir/recolher
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expandido = !expandido }
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(item.pessoa.nome, style = MaterialTheme.typography.titleMedium)
                    Text(
                        "${item.enderecos.size} endereço(s)",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Icon(
                    imageVector = if (expandido) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expandido) "Recolher" else "Expandir"
                )
            }

            // Corpo — só aparece quando expandido
            AnimatedVisibility(visible = expandido) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    if (item.enderecos.isEmpty()) {
                        Text("Nenhum endereço cadastrado.", style = MaterialTheme.typography.bodySmall)
                    } else {
                        item.enderecos.forEach { endereco ->
                            Text(
                                "• ${endereco.logradouro}, ${endereco.numero} - ${endereco.bairro}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(vertical = 2.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}