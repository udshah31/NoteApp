package com.example.noteapp.repositories

import com.example.noteapp.database.AppDatabase
import com.example.noteapp.database.Notes

class NoteRepository(
    val database: AppDatabase
) {
    suspend fun insert(notes: Notes) = database.NoteDao().insert(notes)

    suspend fun update(notes: Notes) = database.NoteDao().update(notes)

    suspend fun delete(notes: Notes) = database.NoteDao().delete(notes)

    fun getAllNotes() = database.NoteDao().getAllNotes()
}