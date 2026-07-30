package br.com.treinamento.moduloconsumoapi3

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.treinamento.moduloconsumoapi3.ui.theme.ModuloConsumoAPI3Theme
import br.com.treinamento.moduloconsumoapi3.view.NotificationScreen

class MainActivity : ComponentActivity() {

    // Registra o gerenciador de resultado que escuta e processa a resposta do usuário sobre a permissão.
    private val notificationPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            println("Permissão de notificação concedida")
        } else {
            println("Permissão de notificação negada")
        }
    }

    // Função que inicia o fluxo visual pedindo a permissão ao usuário.
    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            notificationPermissionLauncher.launch(
                Manifest.permission.POST_NOTIFICATIONS
            )
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestNotificationPermission()
        enableEdgeToEdge()
        setContent {
            NotificationScreen()
        }
    }
}