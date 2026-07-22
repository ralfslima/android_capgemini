package br.com.treinamento.modulopersistencia.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.treinamento.modulopersistencia.viewmodel.PessoaViewModel

@Composable
fun PessoaScreen(viewModel: PessoaViewModel) {

    // Lista de pessoas
    val listaPessoas by viewModel.pessoas.collectAsState()

}