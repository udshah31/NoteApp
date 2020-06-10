package com.example.noteapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Notes)

    @Update
    suspend fun update(note: Notes)

    @Delete
    suspend fun delete(note: Notes)

    @Query("SELECT * FROM Note_list")
    fun getAllNotes(): LiveData<List<Notes>>


}