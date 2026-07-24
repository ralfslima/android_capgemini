package br.com.treinamento.modulopersistencia2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.treinamento.modulopersistencia2.data.local.AppDatabase
import br.com.treinamento.modulopersistencia2.data.repository.PessoaRepository
import br.com.treinamento.modulopersistencia2.data.repository.PessoaRepositoryImpl
import br.com.treinamento.modulopersistencia2.ui.theme.ModuloPersistencia2Theme
import br.com.treinamento.modulopersistencia2.view.PrincipalScreen
import br.com.treinamento.modulopersistencia2.viewmodel.PessoaComEnderecosViewModel
import br.com.treinamento.modulopersistencia2.viewmodel.PessoaComEnderecosViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = AppDatabase.getDatabase(applicationContext)
        val pessoaRepository: PessoaRepository = PessoaRepositoryImpl(database.pessoaDao())
        val enderecosFactory = PessoaComEnderecosViewModelFactory(pessoaRepository)

        setContent {
            val enderecosViewModel: PessoaComEnderecosViewModel = viewModel(factory = enderecosFactory)
            PrincipalScreen(enderecosViewModel)

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
    ModuloPersistencia2Theme {
        Greeting("Android")
    }
}