package br.com.treinamento.modulogestaodeestado.projeto3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun Estado() {

    // Referenciar a data class EstadoInterface
    var estado by remember { mutableStateOf(EstadoInterface()) }

    // Tela
    TelaProjeto3(
        estado = estado,
        aoDigitarNumero1 = { numero -> estado = estado.copy(numero1 = numero) },
        aoDigitarNumero2 = { numero -> estado = estado.copy(numero2 = numero) },
        aoClicar = { operacao ->

            val n1 = estado.numero1.toIntOrNull() ?: 0
            val n2 = estado.numero2.toIntOrNull() ?: 0

            val retornoCalculo = when(operacao) {
                "somar"       -> n1 + n2
                "subtrair"    -> n1 - n2
                "multiplicar" -> n1 * n2
                "dividir"     -> if (n2 != 0) n1 / n2 else 0
                else          -> 0
            }

            estado = estado.copy(resultado = retornoCalculo)

        }

    )

}






