package br.com.treinamento.modulopersistencia2.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PessoaComEnderecosEntity(
    @Embedded
    val pessoa: PessoaEntity,

    @Relation(
        parentColumn = "codigo",       // coluna da tabela "pai" (pessoas)
        entityColumn = "pessoaCodigo"  // coluna da tabela "filha" (endereco) que aponta pra ela
    )
    val enderecos: List<EnderecoEntity>
)