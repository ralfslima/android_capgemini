package br.com.treinamento.modulojetpackcompose.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun Componente07_Slider() {

    // Variável numérica
    var valor by remember { mutableStateOf(50f) }

    // Coluna
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .padding(all = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Valor contido no slider: ${valor.roundToInt()}%")

        Spacer(modifier = Modifier.height(10.dp))

        Slider(
            value = valor,
            onValueChange = { valor = it },
            valueRange = 0f..100f
        )
    }

}





