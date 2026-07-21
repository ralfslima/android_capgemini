package br.com.treinamento.modulopersistencia.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PessoaEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    // Referenciar arquivos DAO
    abstract fun pessoaDao(): PessoaDao

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
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}