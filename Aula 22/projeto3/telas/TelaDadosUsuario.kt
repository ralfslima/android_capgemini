package br.com.treinamento.modulonavegacao.projeto3.telas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.treinamento.modulonavegacao.projeto3.rotas.DadosUsuario

@Composable
fun TelaDadosUsuario(navController: NavController, usuario: DadosUsuario) {

    // Estrutura
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Dados recebidos", fontSize = 30.sp)

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Nome: ${usuario.nome}",     fontSize = 18.sp)
        Text(text = "Idade: ${usuario.idade}",   fontSize = 18.sp)
        Text(text = "Cidade: ${usuario.cidade}", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = { navController.popBackStack() }) { Text("Voltar") }

    }

}