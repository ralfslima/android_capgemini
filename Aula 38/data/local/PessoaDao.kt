package br.com.treinamento.modulopersistencia.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.treinamento.modulopersistencia.model.Pessoa
import kotlinx.coroutines.flow.Flow

@Dao
interface PessoaDao {

    @Query("SELECT * FROM pessoas")
    fun listar(): Flow<List<PessoaEntity>>

    @Insert
    suspend fun cadastrar(pessoa: PessoaEntity)

    @Update
    suspend fun editar(pessoa: PessoaEntity)

    @Delete
    suspend fun remover(pessoa: PessoaEntity)

}







