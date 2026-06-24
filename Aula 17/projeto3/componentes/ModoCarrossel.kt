package br.com.treinamento.modulojetpackcompose.projeto3.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.treinamento.modulojetpackcompose.projeto3.modelos.ItemMenu

@Composable
fun ModoCarrossel(menu: List<ItemMenu>) {
    // Armazenar o estado do carrossel (item visualizado)
    val estadoPagina = rememberPagerState(pageCount = { menu.size })

    // Coluna
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        // HorizontalPager
        HorizontalPager(
            state = estadoPagina,
            pageSize = PageSize.Fixed(145.dp),
            modifier = Modifier.height(100.dp),
            contentPadding = PaddingValues(start = 15.dp, end = 15.dp),
            pageSpacing = 15.dp
        ) {
            // Laço de repetição
                indice ->
            val itemMenu = menu[indice]
            CardCarrossel(itemMenu)
        }
    }
}

@Composable
fun CardCarrossel(itemMenu: ItemMenu) {

    // Card
    Card(
        colors = CardColors(
            containerColor = Color(0xFF8424f2),
            contentColor = Color(0xFFFFFFFF),
            disabledContainerColor = Color(0xFF8424f2),
            disabledContentColor = Color(0xFFFFFFFF)
        )
    ) {
        // Coluna
        Column(
            modifier = Modifier.fillMaxSize().padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = itemMenu.icone,
                contentDescription = itemMenu.texto,
                modifier = Modifier.size(50.dp).padding(bottom = 10.dp)
            )

            Text(itemMenu.texto)

        }// Coluna
    }// Card

}