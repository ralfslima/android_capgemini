package br.com.treinamento.modulonavegacao.projeto1.telas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
// fun TeleInicio(navController: androidx.navigation.NavController) {}
fun TelaInicio(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Tela inicial",
            fontSize = 26.sp
        )

        Button(
            onClick = { navController.navigate("tela_perfil") }
        ) { Text("Perfil") }

        Button(
            onClick = { navController.navigate("tela_configuracao") }
        ) { Text("Configurações") }

        Button(
            onClick = { navController.popBackStack() }
        ) { Text("Voltar") }



    }

}