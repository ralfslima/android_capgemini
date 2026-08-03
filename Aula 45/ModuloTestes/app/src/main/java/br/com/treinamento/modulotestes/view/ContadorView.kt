package br.com.treinamento.modulotestes.view

// Importações
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.treinamento.modulotestes.viewmodel.ContadorViewModel

@Composable
fun ContadorView(viewModel: ContadorViewModel = viewModel()) {

    // Coluna
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Valor: ${viewModel.contador}",
            fontSize = 32.sp,
            modifier = Modifier.testTag("contador_txt")
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { viewModel.incrementar() },
            modifier = Modifier.testTag("incrementar_btn")
        ) {
            Text("Incrementar")
        }
    }

}
