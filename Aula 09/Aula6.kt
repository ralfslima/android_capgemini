package br.com.treinamento.nivelamento

// Inicialização/Execução
fun main() {

    // LAMBDAS NATIVAS
    val texto: String = "Aprendendo a utilizar lambdas"
    println("Quantidade de caracteres: ${texto.count()}")
    println("Quantidade de letras A: ${texto.lowercase().count { it == 'a' }}")

    // CRIAR LAMBDAS
    val somar = { n1: Int, n2: Int -> n1 + n2 }
    val subtrair: (Int, Int) -> Int = { n1: Int, n2: Int -> n1 - n2 }
    println(somar(6, 4))
    println(subtrair(8, 3))

    // HIGHER-ORDER FUNTIONS
    fun calcular(
        n1: Int,
        n2: Int,
        operacao: (Int, Int) -> Int): Int
    {
        return operacao(n1, n2)
    }

    val retornoSoma: Int = calcular(5, 9, { num1, num2 -> num1 + num2 })
    println("A soma dos valores é $retornoSoma")

    val retornoMultiplicacao: Int = calcular(5, 9, { num1, num2 -> num1 * num2 })
    println("A multiplicação dos valores é $retornoMultiplicacao")

    // TRAILING LAMBDA
    val retornoSubtracao: Int = calcular(7, 3) { num1, num2 -> num1 - num2 }
    println("A subtração dos valores é $retornoSubtracao")

}