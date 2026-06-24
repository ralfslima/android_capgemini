package br.com.treinamento.modulojetpackcompose.projeto1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import br.com.treinamento.modulojetpackcompose.projeto1.componentes.Formulario
import br.com.treinamento.modulojetpackcompose.projeto1.componentes.Listagem
import br.com.treinamento.modulojetpackcompose.projeto1.modelos.Pessoa

@Composable
fun Projeto1() {

    // Coleção de pessoas
    var pessoas = remember { mutableStateListOf<Pessoa>() }

    // Estrutura
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
    ) {
        // Formulário
        Formulario(
            acaoCadastro = { novaPessoa -> pessoas.add(novaPessoa) }
        )

        // Listagem
        Listagem(
            pessoas = pessoas,
            acaoRemocao = { pessoaRemovida -> pessoas.remove(pessoaRemovida) }
        )

    }

}