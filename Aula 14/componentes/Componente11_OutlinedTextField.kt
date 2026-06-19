package br.com.treinamento.modulojetpackcompose.componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun Componente11_OutlinedTextField() {

    // Variáveis
    var senha by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(false) }

    // Box
    Box(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {

        //TextField(
        //    value = texto,
        //    onValueChange = { texto = it },
        //)

        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Digite a senha") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = null
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = { senhaVisivel = !senhaVisivel }
                ) {
                    Icon(
                        imageVector = if (senhaVisivel) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation()
        )

    }

}