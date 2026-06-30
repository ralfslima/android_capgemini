package br.com.treinamento.modulonavegacao.projeto2.telas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.treinamento.modulonavegacao.projeto2.rotas.Rotas

@Composable
fun FormularioSoma(navController: NavController) {

    // Variáveis para armazenar os números
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }

    // Estrutura
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 1º número
        TextField(
            value = numero1,
            onValueChange = { numero1 = it },
            placeholder = { Text("1º número") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )

        // 2º número
        TextField(
            value = numero2,
            onValueChange = { numero2 = it },
            placeholder = { Text("2º número") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        )

        // Botão para realizar a soma
        Button(
            onClick = {
                val n1 = numero1.toIntOrNull() ?: 0
                val n2 = numero2.toIntOrNull() ?: 0

                navController.navigate("${Rotas.RETORNO_SOMA}?numero1=$n1&numero2=$n2")
            }
        ) { Text("Realizar soma") }

    }


}