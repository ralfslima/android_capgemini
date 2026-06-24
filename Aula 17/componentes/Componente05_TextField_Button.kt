package br.com.treinamento.modulojetpackcompose.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Componente05_TextField_Button() {

    // Variáveis
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var soma by remember { mutableStateOf(0) }

    // Coluna
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .safeDrawingPadding()
            .padding(all = 10.dp)
    ) {
        TextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Informe o 1º número") },
            //placeholder = { Text("Informe o 1º número") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Informe o 2º número") },
            //placeholder = { Text("Informe o 2º número") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                val n1 = numero1.toIntOrNull() ?: 0
                val n2 = numero2.toIntOrNull() ?: 0
                soma = n1 + n2
            }
        ) {
            Text("Somar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(soma.toString())

    }

}






