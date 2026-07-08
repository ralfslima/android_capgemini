package br.com.treinamento.modulogestaodeestado.projeto1

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
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun Projeto1() {

    // Lista de nomes
    var nomes = remember { mutableStateListOf<String>() }

    // Em carregamento
    var carregamento by remember { mutableStateOf(true) }

    // Delay com Coroutines
    LaunchedEffect(Unit) {
        // Delay
        delay(3000)

        // Cadastrar nomes na lista
        nomes.addAll(listOf("Aline", "Bruna", "Caio", "Diego", "Ellen"))

        // Alterar o valor do carregamento
        carregamento = false
    }

    // Estrutura
    Column(
        modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding()
    ) {
        // Condicional
        if(carregamento) {
            CircularProgressIndicator()
        } else {
            nomes.forEach { Text(it) }
        }
    }
}





