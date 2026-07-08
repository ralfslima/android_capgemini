package br.com.treinamento.modulogestaodeestado.projeto3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaProjeto3(
    estado: EstadoInterface,
    aoDigitarNumero1: (String) -> Unit,
    aoDigitarNumero2: (String) -> Unit,
    aoClicar: (String) -> Unit
) {

    Column(
        modifier = Modifier
                    .safeDrawingPadding()
                    .fillMaxSize()
                    .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1º número
        TextField(
            value = estado.numero1,
            onValueChange = aoDigitarNumero1,
            label = { Text("Informe o 1º número") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // 2º número
        TextField(
            value = estado.numero2,
            onValueChange = aoDigitarNumero2,
            label = { Text("Informe o 2º número") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // Linha 1
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Button(
                onClick = { aoClicar("somar") },
                modifier = Modifier.weight(1f)
            )
            { Text("Somar") }

            Button(
                onClick = { aoClicar("subtrair") },
                modifier = Modifier.weight(1f)
            )
            { Text("Subtrair") }
        }

        // Linha 2
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Button(
                onClick = { aoClicar("multiplicar") },
                modifier = Modifier.weight(1f)
            )
            { Text("Multipliticar") }

            Button(
                onClick = { aoClicar("dividir") },
                modifier = Modifier.weight(1f)
            )
            { Text("Dividir") }
        }

        // Card para exibir os resultados
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = estado.resultado.toString(),
                    fontSize = 26.sp,
                    modifier = Modifier.padding(15.dp)
                )
            }
        }

    }

}



