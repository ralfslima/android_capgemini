package br.com.treinamento.modulojetpackcompose.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun Componente01_Box(){
    Box(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        Text(
            text = "Aprendendo Jetpack Compose",
            fontSize = 26.sp,
            color = Color.White
        )
    }
}