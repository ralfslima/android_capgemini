package br.com.treinamento.modulopersistencia2.model

data class PessoaComEnderecos(
    val pessoa: Pessoa,
    val enderecos: List<Endereco>
)