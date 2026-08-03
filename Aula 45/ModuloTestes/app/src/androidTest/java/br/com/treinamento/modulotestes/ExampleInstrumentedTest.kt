package br.com.treinamento.modulotestes

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.treinamento.modulotestes.view.ContadorView

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val gerenciarComponenteView = createComposeRule()

    @Test
    fun verificarIncremento() {
        // 1. Abrir o app
        gerenciarComponenteView.setContent { ContadorView() }

        // 2. Verificar o valor inicial do Text
        gerenciarComponenteView.onNodeWithTag("contador_txt").assertTextEquals("Valor: 0")

        // 3. "Clicar" no botão
        gerenciarComponenteView.onNodeWithTag("incrementar_btn").performClick()

        // 4. Verificar se o valor do Text foi incrementado
        gerenciarComponenteView.onNodeWithTag("contador_txt").assertTextEquals("Valor: 1")

    }
}