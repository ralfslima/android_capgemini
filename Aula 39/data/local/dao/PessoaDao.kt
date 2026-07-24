package br.com.treinamento.modulopersistencia2.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import br.com.treinamento.modulopersistencia2.data.local.entity.PessoaComEnderecosEntity
import br.com.treinamento.modulopersistencia2.data.local.entity.PessoaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PessoaDao {

    @Transaction
    @Query("SELECT * FROM pessoas")
    fun listarComEnderecos(): Flow<List<PessoaComEnderecosEntity>>

    @Query("SELECT * FROM pessoas")
    fun listar(): Flow<List<PessoaEntity>>

    @Insert
    suspend fun cadastrar(pessoa: PessoaEntity)

    @Update
    suspend fun editar(pessoa: PessoaEntity)

    @Delete
    suspend fun remover(pessoa: PessoaEntity)

}