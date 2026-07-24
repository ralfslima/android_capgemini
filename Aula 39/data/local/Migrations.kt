package br.com.treinamento.modulopersistencia2.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// 1ª Migration
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE pessoas ADD COLUMN idade INTEGER NOT NULL DEFAULT 0")
    }
}

// 2ª Migration
val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE IF NOT EXISTS enderecos (
                codigo INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                bairro TEXT NOT NULL,
                logradouro TEXT NOT NULL,
                numero TEXT NOT NULL,
                pessoaCodigo INTEGER NOT NULL,
                FOREIGN KEY (pessoaCodigo) REFERENCES pessoas(codigo) ON DELETE CASCADE
            )
            """.trimIndent()
        )
        db.execSQL(
            "CREATE INDEX IF NOT EXISTS index_endereco_pessoaCodigo ON endereco(pessoaCodigo)"
        )
    }
}


