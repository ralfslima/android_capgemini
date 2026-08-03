package com.example.recursossmartphone

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
import com.example.recursossmartphone.telas.Bateria
import com.example.recursossmartphone.telas.Camera
import com.example.recursossmartphone.telas.Contatos
import com.example.recursossmartphone.telas.DetectarMovimento
import com.example.recursossmartphone.telas.Geolocalizacao
import com.example.recursossmartphone.telas.VerificarInternet
import com.example.recursossmartphone.telas.VerificarModoDesenvolvedor
import com.example.recursossmartphone.ui.theme.RecursosSmartphoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecursosSmartphoneTheme {
                Camera()
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
    RecursosSmartphoneTheme {
        Greeting("Android")
    }
}