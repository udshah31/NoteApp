package com.example.noteapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

@Database(
    entities = [Notes::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun NoteDao(): NoteDAO

    companion object {
        private var instance: AppDatabase? = null
        private val Lock = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(Lock)
            {
                instance
                    ?: createDatabase(context).also { instance = it }
            }
        private fun createDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,"NoteDB.db"
            ).build()
    }
}