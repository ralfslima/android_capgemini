package br.com.treinamento.moduloarquiteturadesoftware.projeto1.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.recalculateWindowInsets
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.treinamento.moduloarquiteturadesoftware.projeto1.model.ContadorUiEvent
import br.com.treinamento.moduloarquiteturadesoftware.projeto1.viewmodel.ContadorViewModel

@Composable
fun ContadorScreen(viewModel: ContadorViewModel = viewModel()) {

    // Criar referência com o uiState
    val uiState by viewModel.uiState.collectAsState()

    // Referência para controlar a visualização do SnackBar
    val snackBarHostState = remember { SnackbarHostState() }

    // Ao carregar os componentes da tela
    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { evento ->
            when(evento) {
                is ContadorUiEvent.MostrarSnackBar -> {
                    snackBarHostState.showSnackbar(
                        message = evento.mensagem,
                        duration = SnackbarDuration.Short
                    )
                }
            }
        }
    }

    // Estrutura
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(paddingValues)
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Exibir contador
            Text(
                text = "${uiState.contador}",
                fontSize = 50.sp
            )

            // Espaçamento
            Spacer(modifier = Modifier.height(15.dp))

            // Linha
            Row {
                Button(onClick = { viewModel.decrementar() }) { Text("-") }

                Spacer(modifier = Modifier.width(15.dp))

                Button(onClick = { viewModel.incrementar() }) { Text("+") }
            }

        }
    }

}










