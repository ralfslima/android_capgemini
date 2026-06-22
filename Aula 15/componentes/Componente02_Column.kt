package br.com.treinamento.modulojetpackcompose.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Componente02_Column() {

    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Texto 01",
            modifier = Modifier
                .background(Color.Blue)
                .padding(all = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Texto 02",
            modifier = Modifier
                .background(Color.Yellow)
                .padding(all = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Texto 03",
            modifier = Modifier
                .background(Color.Green)
                .padding(all = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Texto 04",
            modifier = Modifier
                .background(Color.Red)
                .padding(all = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }

}









