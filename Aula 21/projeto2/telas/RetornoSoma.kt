package br.com.treinamento.modulonavegacao.projeto2.telas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RetornoSoma(navController: NavController) {

    // Extrair os parâmetros
    val argumentos = navController.currentBackStackEntry?.arguments

    val numero1 = argumentos?.getString("n1")?.toIntOrNull() ?: 0
    val numero2 = argumentos?.getString("n2")?.toIntOrNull() ?: 0

    // Realizar a soma
    val soma = numero1 + numero2

    // Estrutura
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Exibir números e a soma
        Text("A soma de $numero1 + $numero2 é $soma")

        // Espaçamento
        Spacer(modifier = Modifier.height(15.dp))

        // Botão para voltar
        Button(
            onClick = { navController.popBackStack() }
        ) {
            Text("Voltar")
        }
    }

}