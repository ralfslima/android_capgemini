package br.com.treinamento.modulopersistencia.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pessoas")
data class PessoaEntity(
    @PrimaryKey(autoGenerate = true)
    val codigo: Int = 0,
    val nome: String,
    val cidade: String,
    val idade: Int
)
