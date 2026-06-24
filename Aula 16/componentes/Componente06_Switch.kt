package br.com.treinamento.modulojetpackcompose.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/*
100% = 0xFF
90% = 0xE6
80% = 0xCC
70% = 0xB3
60% = 0x99
50% = 0x80
40% = 0x66
30% = 0x4D
20% = 0x33
10% = 0x1A
0% = 0x00
*/

@Composable
fun Componente06_Switch() {

    // Variável para conter uma informação lógica
    var status by remember { mutableStateOf(false) }

    // Coluna
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            //.background(if (status) Color.Blue else Color.LightGray),
            .background(if (status) Color(0xFF7611d4) else Color(0xFFcebc5)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Switch(
            checked = status,
            onCheckedChange = { statusAtualizado -> status = statusAtualizado }
            //onCheckedChange = { status = it }
        )

    }

}






