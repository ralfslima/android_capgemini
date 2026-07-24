package br.com.treinamento.modulopersistencia2.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.treinamento.modulopersistencia2.data.local.dao.EnderecoDao
import br.com.treinamento.modulopersistencia2.data.local.dao.PessoaDao
import br.com.treinamento.modulopersistencia2.data.local.entity.EnderecoEntity
import br.com.treinamento.modulopersistencia2.data.local.entity.PessoaEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [PessoaEntity::class, EnderecoEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    // Referenciar arquivos DAO
    abstract fun pessoaDao(): PessoaDao
    abstract fun enderecoDao(): EnderecoDao

    // Objeto
    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "minha_base"
                )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // Nesse ponto INSTANCE já está atribuído (ver explicação abaixo)
                        INSTANCE?.let { database ->
                            CoroutineScope(Dispatchers.IO).launch {
                                popularBancoInicial(database)
                            }
                        }
                    }
                })
                .build()
                INSTANCE = instance
                instance
            }
        }

    }

}

private suspend fun popularBancoInicial(database: AppDatabase) {
    val pessoaDao = database.pessoaDao()
    val enderecoDao = database.enderecoDao()

    pessoaDao.cadastrar(PessoaEntity(nome = "Ana Souza", idade = 28))
    pessoaDao.cadastrar(PessoaEntity(nome = "Bruno Lima", idade = 34))
    pessoaDao.cadastrar(PessoaEntity(nome = "Carla Mendes", idade = 41))

    // Assumindo que os códigos gerados foram 1, 2 e 3 (banco recém-criado)
    enderecoDao.cadastrar(EnderecoEntity(bairro = "Centro", logradouro = "Rua das Flores", numero = "123", pessoaCodigo = 1))
    enderecoDao.cadastrar(EnderecoEntity(bairro = "Jardim América", logradouro = "Av. Brasil", numero = "456", pessoaCodigo = 1))
    enderecoDao.cadastrar(EnderecoEntity(bairro = "Vila Nova", logradouro = "Rua XV de Novembro", numero = "789", pessoaCodigo = 2))
    enderecoDao.cadastrar(EnderecoEntity(bairro = "Boa Vista", logradouro = "Rua Sete de Setembro", numero = "101", pessoaCodigo = 3))
    enderecoDao.cadastrar(EnderecoEntity(bairro = "Centro", logradouro = "Rua Marechal Deodoro", numero = "202", pessoaCodigo = 3))
}