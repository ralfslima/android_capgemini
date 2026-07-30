package br.com.treinamento.moduloconsumoapi4.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

// Formulário para cadastrar ou editar alunos
@Composable
fun FormAluno(

    codigo: String,
    nome: String,
    nota1: String,
    nota2: String,

    modoEdicao: Boolean,

    onCodigoChange: (String) -> Unit,
    onNomeChange: (String) -> Unit,
    onNota1Change: (String) -> Unit,
    onNota2Change: (String) -> Unit,

    onSalvar: () -> Unit,
    onCancelar: () -> Unit

) {

    Card {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                if (modoEdicao)
                    "Editar aluno"
                else
                    "Cadastrar aluno",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = codigo,
                onValueChange = onCodigoChange,
                enabled = !modoEdicao,
                label = { Text("Código") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value = nome,
                onValueChange = onNomeChange,
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value = nota1,
                onValueChange = onNota1Change,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                label = { Text("Nota 1") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value = nota2,
                onValueChange = onNota2Change,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                label = { Text("Nota 2") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(16.dp))

            if (!modoEdicao) {

                Button(
                    onClick = onSalvar,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text("Cadastrar")

                }

            } else {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    OutlinedButton(
                        modifier = Modifier.weight(1f),
                        onClick = onCancelar
                    ) {

                        Text("Cancelar")

                    }

                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = onSalvar
                    ) {

                        Text("Atualizar")

                    }

                }

            }

        }

    }

}