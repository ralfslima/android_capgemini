package br.com.treinamento.modulogestaodeestado.projeto4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

@Composable
fun Estado() {

    // StateFlow
    val stateFlow = remember { MutableStateFlow(EstadoInterface()) }

    // Estado para atualizar a UI
    val estado by stateFlow.collectAsState()

    // Variável para incrementar o id
    var gerarId by remember { mutableStateOf(1) }

    // Gerar Tela
    TelaProjeto4(
        estado = estado,

        aoDigitarNome = { valor ->
            stateFlow.update { it.copy(nome = valor) }
        },

        aoDigitarCidade = { valor ->
            stateFlow.update { it.copy(cidade = valor) }
        },

        aoCadastrar = {
            val novaPessoa = Pessoa(
                id = gerarId++,
                nome = estado.nome,
                cidade = estado.cidade
            )

            stateFlow.update {
                it.copy(
                    pessoas = it.pessoas + novaPessoa,
                    nome = "",
                    cidade = ""
                )
            }
        },

        aoRemover = { pessoaParaRemover ->
            stateFlow.update {
                estado -> estado.copy(
                    pessoas = estado.pessoas.filter { it.id != pessoaParaRemover.id }
                )
            }
        }
    )

}





