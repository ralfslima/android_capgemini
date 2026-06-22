package br.com.treinamento.modulojetpackcompose.projeto1.componentes

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Botao(texto: String, corFundo: Color, acao: () -> Unit) {
    Button(
        onClick = acao,
        colors = ButtonDefaults.buttonColors(containerColor = corFundo)
    ) { Text(texto) }
}