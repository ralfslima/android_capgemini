package br.com.treinamento.modulojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.treinamento.modulojetpackcompose.componentes.Componente01_Box
import br.com.treinamento.modulojetpackcompose.componentes.Componente02_Column
import br.com.treinamento.modulojetpackcompose.componentes.Componente03_Row
import br.com.treinamento.modulojetpackcompose.componentes.Componente04_LazyColumn
import br.com.treinamento.modulojetpackcompose.ui.theme.ModuloJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModuloJetpackComposeTheme {
                //Componente01_Box()
                //Componente02_Column()
                //Componente03_Row()
                Componente04_LazyColumn(nomes = listOf("Ralf", "Jéssica", "Carla"))
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ModuloJetpackComposeTheme {
        Componente04_LazyColumn(nomes = listOf("Ralf", "Jéssica", "Carla"))
    }
}