package br.com.treinamento.modulopersistencia

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
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.treinamento.modulopersistencia.data.local.AppDatabase
import br.com.treinamento.modulopersistencia.data.repository.PessoaRepository
import br.com.treinamento.modulopersistencia.data.repository.PessoaRepositoryImpl
import br.com.treinamento.modulopersistencia.ui.theme.ModuloPersistenciaTheme
import br.com.treinamento.modulopersistencia.view.PessoaScreen
import br.com.treinamento.modulopersistencia.viewmodel.PessoaViewModel
import br.com.treinamento.modulopersistencia.viewmodel.PessoaViewModelFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Referências - DAO, REPOSITORY E FACTORY
        val dao = AppDatabase.getDatabase(applicationContext).pessoaDao()
        val repository: PessoaRepository = PessoaRepositoryImpl(dao)
        val factory = PessoaViewModelFactory(repository)

        setContent {
            // Referência ViewModel
            val viewModel: PessoaViewModel = viewModel(factory = factory)

            // Cadastro de testes
            //viewModel.cadastrar("Ralf", "Florianópolis")

            // View
            PessoaScreen(viewModel)

            //ModuloPersistenciaTheme {
            //    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            //        Greeting(
            //            name = "Android",
            //            modifier = Modifier.padding(innerPadding)
            //        )
            //    }
            //}
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
    ModuloPersistenciaTheme {
        Greeting("Android")
    }
}