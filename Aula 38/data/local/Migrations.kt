package br.com.treinamento.modulopersistencia.data.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// 1ª Migration
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE pessoas ADD COLUMN idade INTEGER NOT NULL DEFAULT 0")
    }
}


