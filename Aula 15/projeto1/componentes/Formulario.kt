package br.com.treinamento.modulojetpackcompose.projeto1.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import br.com.treinamento.modulojetpackcompose.projeto1.modelos.Pessoa

@Composable
fun Formulario(acaoCadastro: (Pessoa) -> Unit) {

    // Variáveis
    var nome   by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    // Estrutura (layout)
    Column(
        modifier = Modifier.padding(all = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Nome
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        // Cidade
        OutlinedTextField(
            value = cidade,
            onValueChange = { cidade = it },
            label = { Text("Cidade") },
            modifier = Modifier.fillMaxWidth()
        )

        // Botão (sem trailing lambda)
        //Botao(
        //    texto = "Cadastrar",
        //    corFundo = Color(0xFF4457eb),
        //    acao = {
        //        acaoCadastro(Pessoa(nome, cidade))
        //    }
        //)

        // Botao (com trailing lambda)
        Botao(
            texto = "Cadastrar",
            corFundo = Color(0xFF4457eb)
        ) {
            acaoCadastro(Pessoa(nome, cidade))

            nome = ""
            cidade = ""

            focusManager.clearFocus()
        }

    }

}

