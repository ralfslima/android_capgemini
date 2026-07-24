package br.com.treinamento.modulopersistencia2.data.local.dao

import androidx.room.*
import br.com.treinamento.modulopersistencia2.data.local.entity.EnderecoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EnderecoDao {

    @Query("SELECT * FROM enderecos WHERE pessoaCodigo = :pessoaCodigo")
    fun listarPorPessoa(pessoaCodigo: Int): Flow<List<EnderecoEntity>>

    @Insert
    suspend fun cadastrar(endereco: EnderecoEntity)

    @Update
    suspend fun editar(endereco: EnderecoEntity)

    @Delete
    suspend fun remover(endereco: EnderecoEntity)
}