package br.com.treinamento.modulonavegacao

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
import br.com.treinamento.modulonavegacao.projeto1.Projeto1
import br.com.treinamento.modulonavegacao.projeto2.Projeto2
import br.com.treinamento.modulonavegacao.projeto3.Projeto3
import br.com.treinamento.modulonavegacao.projeto4.Projeto4
import br.com.treinamento.modulonavegacao.ui.theme.ModuloNavegacaoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Projeto1()
            //Projeto2()
            //Projeto3()
            Projeto4()
//            ModuloNavegacaoTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
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
    ModuloNavegacaoTheme {
        Greeting("Android")
    }
}