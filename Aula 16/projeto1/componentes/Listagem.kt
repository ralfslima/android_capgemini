package br.com.treinamento.modulojetpackcompose.projeto1.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.treinamento.modulojetpackcompose.projeto1.modelos.Pessoa

@Composable
fun Listagem(pessoas: List<Pessoa>, acaoRemocao: (Pessoa) -> Unit) {

    // Estrutura
    LazyColumn(
        modifier = Modifier.padding(all = 15.dp),
    ) {
        // Laço de repetição
        items(pessoas) { pessoa ->
            Row() {
                Column() {
                    Text(pessoa.nome)
                    Text(pessoa.cidade)
                }

                Botao(texto = "Remover", corFundo = Color(0xFFd44b3b)) {
                    acaoRemocao(pessoa)
                }
            }
        }
    }

}