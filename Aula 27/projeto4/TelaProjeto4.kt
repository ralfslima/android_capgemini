package br.com.treinamento.modulogestaodeestado.projeto4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaProjeto4(
    estado: EstadoInterface,
    aoDigitarNome:   (String) -> Unit,
    aoDigitarCidade: (String) -> Unit,
    aoCadastrar: () -> Unit,
    aoRemover: (Pessoa) -> Unit
) {

    // Coluna
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        // TextField - Nome
        TextField(
            value = estado.nome,
            onValueChange = aoDigitarNome,
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        // TextField - Cidade
        TextField(
            value = estado.cidade,
            onValueChange = aoDigitarCidade,
            label = { Text("Cidade") },
            modifier = Modifier.fillMaxWidth()
        )

        // Button - Cadastrar
        Button(
            onClick = aoCadastrar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cadastrar")
        }

        // LazyColumn - Listar pessoas
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(estado.pessoas) { pessoa ->

                // Card
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Linha
                    Row(
                        modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Coluna
                        Column {
                            Text(
                                text = "Nome: ${pessoa.nome}",
                                modifier = Modifier.padding(bottom = 5.dp),
                                fontSize = 16.sp
                            )
                            Text(
                                text = "Cidade: ${pessoa.cidade}",
                                fontSize = 16.sp
                            )
                        }

                        // Botão de remoção
                        IconButton(
                            onClick = { aoRemover(pessoa) }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = null
                            )
                        }
                    }
                }

            }
        }

    }

}
