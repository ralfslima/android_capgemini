package br.com.treinamento.nivelamento



// ********* HERANÇA #1
//open class Pessoa {
//    var nome: String = ""
//    var idade: Int = 0
//}
//
//class Colaborador : Pessoa() {
//    var cargo: String = ""
//    var salario: Double = 0.0
//}


// ********** HERANÇA #2
//open class Pessoa {
//    private var nome: String = ""
//    private var idade: Int = 0
//
//    constructor(nome: String, idade: Int) {
//       this.nome = nome
//        this.idade = idade
//    }
//}
//
//class Colaborador : Pessoa {
//    private var cargo: String = ""
//    private var salario: Double = 0.0
//
//    constructor(nome: String, idade: Int, cargo: String, salario: Double) : super(nome, idade) {
//        this.cargo = cargo
//        this.salario = salario
//    }
//
//}


// ********** HERANÇA #3
//open class Pessoa(protected val nome: String, protected val idade: Int) {}
//class Colaborador(nome: String, idade: Int, private val cargo: String, private val salario: Double) : Pessoa(nome, idade) {}



// ********** ABSTRAÇÃO
//data class Produto(val nome: String, val valor: Double) {}
//
//abstract class AcoesCRUD {
//    abstract fun cadastrar(obj: Produto): Boolean
//    abstract fun listar(): List<Produto>
//    abstract fun alterar(posicao: Int, obj: Produto): Boolean
//    abstract fun remover(posicao: Int): Boolean
//
//    fun quantidadeProdutos(): Int{
//        return 0
//    }
//}
//
//class GerenciarProdutos : AcoesCRUD() {
//    override fun cadastrar(obj: Produto): Boolean {
//        TODO("Not yet implemented")
//    }
//
//    override fun listar(): List<Produto> {
//        TODO("Not yet implemented")
//    }
//
//    override fun alterar(posicao: Int, obj: Produto): Boolean {
//        TODO("Not yet implemented")
//    }
//
//    override fun remover(posicao: Int): Boolean {
//        TODO("Not yet implemented")
//    }
//}


// ********** INTERFACE
//interface ICalculadoraAvancada {
//    fun seno(numero: Double): Double
//    fun cosseno(numero: Double): Double
//}
//
//interface ICalculadoraSimples {
//
//    val nome: String get() = "Ralf" // <- Disponibilizar valor
//
//    fun somar(numero1: Int, numero2: Int): Int
//    fun subtrair(numero1: Int, numero2: Int): Int
//
//    fun multiplicar(numero1: Int, numero2: Int): Int {
//        return numero1 * numero2
//    }
//}
//
//class ExecutarCalculos(override val nome: String) : ICalculadoraSimples, ICalculadoraAvancada {
//    override fun somar(numero1: Int, numero2: Int): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun subtrair(numero1: Int, numero2: Int): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun seno(numero: Double): Double {
//        TODO("Not yet implemented")
//    }
//
//    override fun cosseno(numero: Double): Double {
//        TODO("Not yet implemented")
//    }
//}

/*
    CLASSE ABSTRATA X INTERFACE

    1. Interface é permito utilizar "herança múltipla", classe abstrata não pode.

    2. Classe abstrata pode ter construtor, interface não.

    3. Classes abstratam podem ter atributos com valores, interfaces apenas atributos onde os valores serão definidos nas classes que implementarem as interfaces.
*/








// Metodo de execução
fun main() {
    //var obj = ExecutarCalculos("Ralf")
    //var obj = Colaborador("Robson", 22, "Analista de Sistemas", 5800.00)
    //var obj = Colaborador()
    //obj.nome = "Robson"
    //obj.idade = 22
    //obj.cargo = "Analista de Sistemas"
    //obj.salario = 5800.00
}