package br.com.treinamento.nivelamento

import java.lang.Thread.sleep

// ********** ATRIBUTOS E MÉTODOS ESTÁTICOS
//class Usuario {
//
//    // Agrupar atributos e métodos estáticos
//    companion object {
//        // Atributo
//        var nome: String = "Ralf"
//
//        // Metodo/Função
//        fun mensagem() {
//            println("Hello Usuário!")
//        }
//    }
//
//}





// ********** DATA CLASS
//data class Produto(val nome: String, val marca: String, val valor: Double) {}
/*
    toString(): É implementado automaticamente
    copy(): Criar uma cópia sem vínculo
*/





// ********** CONSTRUTOR #2
//class Produto(val nome: String, val marca: String, val valor: Double) {} // Construtor primário



// ********** CONSTRUTOR #1
//class Produto {
//    // Atributos
//    private var nome: String = ""
//    private var marca: String = ""
//    private var valor: Double = 0.0
//
//    // Construtor secundário
//    constructor(nome: String, marca: String, valor: Double) {
//        this.nome = nome
//        this.marca = marca
//        this.valor = valor
//    }
//
//}





// ********** MODIFICADORES DE ACESSO
/*
    public: (padrão/default): Atributos e métodos visíveis no projeto
    private: Atributos e métodos visíveis apenas na classe onde são criados
    protected: Atributos e métodos visíveis na classe onde são criados ou herdados
    internal: Classes, atributos e métodos visíveis apenas no módulo
*/




// ********** CLASSE, ATRIBUTO, METODO E OBJETO
//class Pessoa {
//    /*
//        VAR: GET e SET são criados.
//        VAL: GET é criado.
//
//        PRIVATE SET: Bloqueia o uso do SET.
//    */
//
//    // Atributos
//    var nome: String = ""
//        set(valor) {
//            field = valor.lowercase().replaceFirstChar { it.uppercase() }
//        }
//        get() {
//            return field.uppercase()
//        }
//
//    var idade: Int = 0
//        //private set
//
//    // Métodos
//    fun apresentacao() {
//        println("Olá $nome, você tem $idade anos.")
//    }
//
//}

// Executar projeto
fun main() {
    // Objeto do tipo Pessoa
    //val obj = Pessoa()
    //obj.nome = "alice"
    //obj.idade = 32
    //obj.apresentacao()

    // Testar o metodo copy() da data classe
    //var obj1 = Produto("Teclado", "Dell", 127.90)
    //var obj2 = obj1.copy(nome = "Mouse", valor = 49.90)
    //println(obj1)
    //println(obj2)

    //println(Usuario.nome)
    //Usuario.mensagem()
}
