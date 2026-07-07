package br.com.treinamento.modulogestaodeestado.projeto2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun Projeto2() {

    // EstadoInterface - StateUI
    var estado by remember { mutableStateOf(EstadoInterface()) }

    // Delay com Coroutines
    LaunchedEffect(Unit) {
        // Delay
        delay(3000)

        // Cadastrar nomes na lista e alterar o valor do carregamento
        estado = EstadoInterface(
            nomes = listOf("Aline", "Bruna", "Caio", "Diego", "Ellen"),
            carregamento = false
        )
    }

    // Estrutura
    Column(
        modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Condicional
        if(estado.carregamento) {
            CircularProgressIndicator()
        } else {
            estado.nomes.forEach { Text(it) }
        }
    }
}





