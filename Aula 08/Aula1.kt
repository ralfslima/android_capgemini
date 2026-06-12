package br.com.treinamento.nivelamento

// Estrutura de função
fun main(){

    // *******************************************
    // Elvis Operator
    var nomeUsuario: String? = null
    var nome: String = nomeUsuario ?: "Visitante"
    print(nome)


    // *******************************************
    // Constantes
    //val dolar: Double = 5.10


    // *******************************************
    // Variáveis
    //var nome: String = "Ralf"
    //var idade: Int = 36
    //var cidade: String? = null  //<- Null Safety

    //println("Olá " + nome + ", você tem " + idade + " anos.") // <- Não usual
    //println("Olá $nome, você tem $idade anos.")  // <- Usual


    // *******************************************
    // Exibir mensagem
    //print("Hello World!")

}

