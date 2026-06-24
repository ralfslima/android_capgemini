package br.com.treinamento.modulojetpackcompose.componentes


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Componente10_AlertDialog() {

    // Variável para visulizar o AlertDialog
    var mostrarAlerta by remember { mutableStateOf(false) }

    // Box
    Box(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {

        // Botão
        Button(onClick = { mostrarAlerta = true }) {
            Text("Clique aqui")
        }

        // AlertDialog
        if (mostrarAlerta) {
            AlertDialog(
                onDismissRequest = { mostrarAlerta = false },
                title = { Text("Meu primeiro modal") },
                text = { Text("Está gostando desse componente?") },
                confirmButton = {
                    TextButton(onClick = { mostrarAlerta = false }) {
                        Text("Ok")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { mostrarAlerta = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }

    }

}






