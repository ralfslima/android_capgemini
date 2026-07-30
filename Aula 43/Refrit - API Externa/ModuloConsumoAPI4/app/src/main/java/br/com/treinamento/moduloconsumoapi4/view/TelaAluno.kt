package br.com.treinamento.moduloconsumoapi4.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.treinamento.moduloconsumoapi4.data.remote.dto.AtualizarAlunoDTO
import br.com.treinamento.moduloconsumoapi4.data.remote.dto.NovoAlunoDTO
import br.com.treinamento.moduloconsumoapi4.viewmodel.AlunoViewModel

// Interface Gráfica
@Composable
fun TelaAluno(vm: AlunoViewModel = viewModel()){
    val estado by vm.uiState.collectAsState()

    Column(

        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp)

    ){


        FormAluno(

            codigo =
                estado.codigo,


            nome =
                estado.nome,


            nota1 =
                estado.nota1,


            nota2 =
                estado.nota2,


            modoEdicao =
                estado.modoEdicao,



            onCodigoChange = {
                vm.alterarCodigo(it)
            },


            onNomeChange = {
                vm.alterarNome(it)
            },


            onNota1Change = {
                vm.alterarNota1(it)
            },


            onNota2Change = {
                vm.alterarNota2(it)
            },


            onSalvar = {

                vm.salvar()

            },


            onCancelar = {

                vm.cancelarEdicao()

            }


        )



        Spacer(
            Modifier.height(16.dp)
        )



        HorizontalDivider()



        Spacer(
            Modifier.height(16.dp)
        )



        LazyColumn {


            items(
                estado.alunos
            ){ aluno ->


                CardAluno(

                    aluno = aluno,


                    onEditar = {

                        vm.editarAluno(it)

                    },


                    onExcluir = {

                        vm.excluirAluno(it.codigo)

                    }

                )


            }


        }


    }


}