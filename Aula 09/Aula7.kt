package br.com.treinamento.nivelamento

import java.lang.Thread.sleep


// Função de extensão | Extension Function
fun String.contarVogais(): Int {
    val vogais = setOf('a', 'e', 'i', 'o', 'u')
    return this.lowercase().count{ it in vogais  }
}


// ENUMS
//enum class Linguagens { JAVA, KOTLIN, PYTHON, GO }

// Classe selada
sealed class StatusLogin {
    object AguardandoCodigo: StatusLogin()
    object ValidandoNoServidor: StatusLogin()
    data class Sucesso(val token: String): StatusLogin()
    data class Falha(val mensagem: String): StatusLogin()
}

fun validarCodigo(codigo: String): StatusLogin{
    // Mensagem de validação
    println("===== REALIZANDO VALIDAÇÃO =====")

    // Temporizador
    for(indice in 3 downTo 1) {
        print("$indice...")
        sleep(1000)
    }
    println()

    // Condicional
    return if (codigo == "1234") {
        StatusLogin.Sucesso(token = "F5v15LeW60PKvvLr")
    } else {
        StatusLogin.Falha(mensagem = "Código inválido")
    }
}


// SMART CAST
class Email(val endereco: String, val assunto: String)
class SMS(val numero: String, val assunto: String)

fun verificarTipoMensagem(mensagem: Any) {

    when (mensagem) {
        is Email -> {
            println("Mensagem do tipo E-mail")
            println("Endereço: ${mensagem.endereco}")
            println("Assunto: ${mensagem.assunto}")
        }
        is SMS -> {
            println("Mensagem do tipo SMS")
            println("Número: ${mensagem.numero}")
            println("Assunto: ${mensagem.assunto}")
        }
        else -> println("Não é possível visualizar a mensagem")
    }

}


// Inicializar projeto/script
fun main() {
    val mensagemEmail = Email("contato@gmail.com", "Smart Cast")
    val mensagemSMS = SMS("11 99998-9876", "Smart Cast")
    val mensagemTexto = "Smart Cast"

    verificarTipoMensagem(mensagemEmail)
    verificarTipoMensagem(mensagemSMS)
    verificarTipoMensagem(mensagemTexto)





    // AUTENTICAR CÓDIGO
    //println("===== SISTEMA DE VALIDAÇÃO =====")
    //println("Informe o código enviado")
    //
    //// Referência de status
    //var status: StatusLogin = StatusLogin.AguardandoCodigo
    //
    //// Laço de repetição
    //while (true) {
    //
    //    // Verificações
    //    when (status) {
    //        is StatusLogin.AguardandoCodigo -> {
    //            println("Informe o código:")
    //            val codigo: String = readln()
    //
    //            status = StatusLogin.ValidandoNoServidor
    //
    //            status = validarCodigo(codigo)
    //        }
    //
    //        is StatusLogin.ValidandoNoServidor -> {
    //            println("Processando...")
    //        }
    //
    //        is StatusLogin.Sucesso -> {
    //            println("Token gerado com sucesso!")
    //            println("Seu token é: ${status.token}")
    //            break
    //        }
    //
    //        is StatusLogin.Falha -> {
    //            println("Falha ao autenticar: ${status.mensagem}")
    //            status = StatusLogin.AguardandoCodigo
    //        }
    //
    //    }
    //
    //}


    // *****************************************************

    //println(Linguagens.KOTLIN)

    //val texto = "Aprendendo a utilizar extension function"
    //println(texto.contarVogais())
}





