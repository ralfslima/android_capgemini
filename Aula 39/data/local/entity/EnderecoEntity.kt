package br.com.treinamento.modulopersistencia2.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "enderecos",
    foreignKeys = [
        ForeignKey(
            entity = PessoaEntity::class,
            parentColumns = ["codigo"],
            childColumns = ["pessoaCodigo"],
            onDelete = ForeignKey.CASCADE // se a pessoa for excluída, seus endereços somem junto
        )
    ],
    indices = [Index(value = ["pessoaCodigo"])] // Room recomenda (e exige em lint) índice na FK
)
data class EnderecoEntity(
    @PrimaryKey(autoGenerate = true)
    val codigo: Int = 0,
    val bairro: String,
    val logradouro: String,
    val numero: String,
    val pessoaCodigo: Int // a chave estrangeira: a qual pessoa este endereço pertence
)