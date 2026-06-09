package br.com.treinamento.nivelamento

// Execução do script
fun main(){

    // *************************************************
    // Interação com o usuário
    println("Olá! Informe seu nome")
    var nome: String = readln()

    println("$nome, informe sua idade")
    var idade: Int = readln().toInt()

    println("$nome tem $idade anos")




    // *************************************************
    // Para (FOR)
    //for (indice in 1 until 5) {
    //    println(indice) // 1, 2, 3, 4
    //}

    //for (indice in 5 downTo 1) {
    //    println(indice) // 5, 4, 3, 2, 1
    //}

    //for (indice in 1..10) {
    //    println(indice)
    //}

    //for (letra in 'a'..'z') {
    //    println(letra)
    //}

    //for (indice in 1..10 step 2) {
    //    println(indice)
    //}

    // *************************************************
    // Faça Enquanto (DO WHILE)
    //var indice: Int = 10
    //do {
    //    println(indice)
    //    indice-- // -1
    //} while (indice >= 1)

    // *************************************************
    // Enquanto (WHILE)
    //var indice: Int = 1
    //while (indice <= 10) {
    //    println(indice)
    //    indice++ // +1
    //}


    // *************************************************
    // Quando (WHEN)
    //val dia: Int = 5
    //
    //val diaDaSemana: String = when (dia) {
    //    1 -> "Segunda-feira"
    //    2 -> "Terça-feira"
    //    3 -> "Quarta-feira"
    //    4 -> "Quinta-feira"
    //    5 -> "Sexta-feira"
    //    6 -> "Sábado"
    //    7 -> "Domingo"
    //    else -> "Dia inválido"
    //}




    // *************************************************
    // Operador ternário
    //val media: Double = 7.0
    //val situacao: String = if (media >= 7) "Aprovado(a)" else "Reprovado(a)"
    //print(if (media >= 7) "Aprovado(a)" else "Reprovado(a)")

    //if (media >= 7) {
    //    print("Aprovado(a)")
    //} else {
    //    print("Reprovado(a)")
    //}



    // *************************************************
    // Condicional
    //val media: Double = 8.5
    //
    //if (media >= 7) {
    //    print("Aprovado(a) com média $media")
    //} else if (media >= 5) {
    //    print("Em exame com média $media")
    //} else {
    //    print("Reprovado(a) com média $media")
    //}


    // *************************************************
    /*
        OPERADORES RELACIONAIS
        >    MAIOR
        <    MENOR
        >=   MAIOR OU IGUAL
        <=   MENOR OU IGUAL
        ==   IGUAL (Verifica apenas o valor)
        ===  IGUAL (Verifica o endereço de memória)
        !=   DIFERENTE (Verifica apenas o valor)
        !==  DIFERENTE (Verifica o endereço de memória)
    */

    //val nome1: String = "Ralf"
    //val nome2: String = String(charArrayOf('R', 'a', 'l', 'f'))
    //print(nome1 === nome2)


    // *************************************************
    /*
        OPERADORES LÓGICOS
        &&   E
        ||   OU
        !    NEGAÇÃO
    */


    // *************************************************
    /*
        OPERADORES ARITMÉTICOS
        +   SOMA: 2+2 = 4
        -   SUBTRAÇÃO: 10-3 = 7
        *   MULTIPLICAÇÃO: 5*5 = 25
        /   DIVISÃO: 10/2 = 5
        %   RESTO DA DIVISÃO (MÓDULO): 17%2 = 1
    */

}