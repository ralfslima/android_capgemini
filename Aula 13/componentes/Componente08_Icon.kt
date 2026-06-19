package br.com.treinamento.modulojetpackcompose.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Square
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material.icons.twotone.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Componente08_Icon() {

    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
            .padding(15.dp)
    ) {

        // 1º Ícone
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = "Tela inicial"
        )


        // 2º Ícone
        Icon(
            imageVector = Icons.Outlined.StarBorder,
            contentDescription = "Estrela"
        )

        // 3º Ícone
        Icon(
            imageVector = Icons.Rounded.ShoppingCart,
            contentDescription = "Carrinho de compras"
        )

        // 4º Ícone
        Icon(
            imageVector = Icons.Sharp.Person,
            contentDescription = "Pessoa"
        )

        // 5º Ícone
        Icon(
            imageVector = Icons.TwoTone.Edit,
            contentDescription = "Editar"
        )

        // Botão + Ícone
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Filled.Square,
                contentDescription = null
            )
        }

    }

}