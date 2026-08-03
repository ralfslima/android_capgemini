package br.com.treinamento.modulotestes

import br.com.treinamento.modulotestes.viewmodel.ContadorViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun valorInicial() {
        // Referenciar ViewModel
        val viewModel = ContadorViewModel()

        // Verificar se o contador inicia com zero
        assertEquals(0, viewModel.contador)
    }

    @Test
    fun verificarIncremento() {
        // Referenciar ViewModel
        val viewModel = ContadorViewModel()

        // Executar a função de incremento
        viewModel.incrementar()

        // Verificar se o contador incrementou
        assertEquals(1, viewModel.contador)
    }

}