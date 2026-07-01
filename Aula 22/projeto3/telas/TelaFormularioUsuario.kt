package br.com.treinamento.modulonavegacao.projeto3.telas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.treinamento.modulonavegacao.projeto3.rotas.DadosUsuario

@Composable
fun TelaFormularioUsuario(navController: NavController) {

    // Variáveis
    var nome   by remember { mutableStateOf("") }
    var idade  by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }

    // Estrutura
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Nome
        TextField(
            value = nome,
            onValueChange = { nome = it },
            placeholder = { Text("Nome") },
            modifier = Modifier.padding(bottom = 10.dp).fillMaxWidth()
        )

        // Idade
        TextField(
            value = idade,
            onValueChange = { idade = it },
            placeholder = { Text("Idade") },
            modifier = Modifier.padding(bottom = 10.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // Cidade
        TextField(
            value = cidade,
            onValueChange = { cidade = it },
            placeholder = { Text("Cidade") },
            modifier = Modifier.padding(bottom = 10.dp).fillMaxWidth()
        )

        // Botão
        Button(
            onClick = {
                navController.navigate(
                    DadosUsuario(nome, idade.toIntOrNull() ?: 0, cidade)
                )
            }
        ) { Text("Enviar") }
    }

}