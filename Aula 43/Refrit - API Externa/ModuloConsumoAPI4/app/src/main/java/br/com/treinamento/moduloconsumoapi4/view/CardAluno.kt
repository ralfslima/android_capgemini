package br.com.treinamento.moduloconsumoapi4.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.treinamento.moduloconsumoapi4.model.Aluno

// Interface gráfica - Card aluno
@Composable
fun CardAluno(

    aluno: Aluno,

    onEditar: (Aluno) -> Unit,

    onExcluir: (Aluno) -> Unit

) {

    ElevatedCard(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                aluno.nome,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(8.dp))

            Text("Código: ${aluno.codigo}")
            Text("Nota 1: ${aluno.nota1}")
            Text("Nota 2: ${aluno.nota2}")
            Text("Média: ${aluno.media}")
            Text("Situação: ${aluno.situacao}")

            Spacer(Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {

                IconButton(
                    onClick = {
                        onEditar(aluno)
                    }
                ) {

                    Icon(
                        Icons.Default.Edit,
                        contentDescription = "Editar"
                    )

                }

                IconButton(
                    onClick = {
                        onExcluir(aluno)
                    }
                ) {

                    Icon(
                        Icons.Default.Delete,
                        contentDescription = "Excluir"
                    )

                }

            }

        }

    }

}