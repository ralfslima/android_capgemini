package br.com.treinamento.moduloconsumoapi3.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.treinamento.moduloconsumoapi3.viewmodel.NotificationViewModel

@Composable
fun NotificationScreen(viewModel: NotificationViewModel = viewModel()) {

    // Obter token
    val token by viewModel.token.collectAsState()

    // Notificação
    val notification by viewModel.notification.collectAsState()

    // Estrutura
    Column(
        modifier =
            Modifier
                .padding(20.dp)
    ) {


        Button(
            onClick = {
                viewModel.loadToken()
            }
        ) {
            Text("Gerar Token")
        }

        Spacer(Modifier.height(20.dp))

        Text(text = "Token:")

        Text(text = token)

        Spacer(Modifier.height(20.dp))

        notification?.let {
            Text(text = "Mensagem: ${it.message}")
        }

    }
}
