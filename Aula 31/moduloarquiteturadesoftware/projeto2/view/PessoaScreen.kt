package br.com.treinamento.moduloarquiteturadesoftware.projeto2.view

import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import br.com.treinamento.moduloarquiteturadesoftware.projeto2.model.Pessoa
import br.com.treinamento.moduloarquiteturadesoftware.projeto2.viewmodel.PessoaViewModel

@Composable
fun PessoaScreen(viewModel: PessoaViewModel = hiltViewModel()) {

    // Referência para obter a lista de pessoas
    val listaPessoas by viewModel.pessoas.collectAsState()

    // Listagem de pessoas
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(listaPessoas) { pessoa -> PessoaCard(pessoa) }
    }
}

@Composable
fun PessoaCard(pessoa: Pessoa) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text("Nome: ${pessoa.nome}")
            Text("Cidade: ${pessoa.cidade}")
            Text("Idade: ${pessoa.idade}")
        }
    }
}
