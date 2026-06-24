package br.com.treinamento.modulojetpackcompose.projeto2

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.treinamento.modulojetpackcompose.R

@Composable
fun Projeto2() {

    // Lista de pessoas
    val lista = remember {
        mutableStateListOf(
            Pessoa("Crstiano", "img1"),
            Pessoa("Juliana",  "img7"),
            Pessoa("Bianca",   "img8"),
            Pessoa("Gustavo",  "img2"),
            Pessoa("Fernanda", "img9"),
            Pessoa("Henrique", "img3"),
            Pessoa("Robson",   "img4"),
            Pessoa("Luciana",  "img10"),
            Pessoa("Sara",     "img11"),
            Pessoa("Paulo",    "img5"),
            Pessoa("Adriane",  "img12"),
            Pessoa("Giovane",  "img6")
        )
    }

    // Contexto (para extrair as imagens)
    val contexto = LocalContext.current

    // Verificar o modo do celular (paisagem)
    val modoCelular = LocalConfiguration.current
    val modoPaisagem = modoCelular.orientation == Configuration.ORIENTATION_LANDSCAPE

    // Disponibilizar a quantidade de colunas
    val colunas = if(modoPaisagem) 4 else 2

    // Estrutura
    LazyVerticalGrid(
        columns = GridCells.Fixed(colunas),
        modifier = Modifier
                    .safeDrawingPadding()
                    .fillMaxSize(),
        contentPadding = PaddingValues(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(lista) { pessoa ->

            // Obter imagem específica
            val imagem = remember<Int>(pessoa.imagem) {
                contexto.resources.getIdentifier(
                    pessoa.imagem,
                    "drawable",
                    contexto.packageName
                )
            }


            // ElevatedCard
            ElevatedCard(
                modifier = Modifier.clickable() {},
                shape = RoundedCornerShape(0.dp)
            ) {
                // Coluna
                Column(
                    modifier = Modifier.fillMaxWidth().padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier.size(width = 200.dp, height = 150.dp),
                        painter = painterResource(id = imagem),
                        contentDescription = null
                    )
                    Text(pessoa.nome)
                }
            }

        }
    }


}