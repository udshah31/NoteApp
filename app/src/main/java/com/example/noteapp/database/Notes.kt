package com.example.noteapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Note_list")
data class Notes(
    @ColumnInfo(name = "note_title")
    var title: String,

    @ColumnInfo(name = "note_description")
    var description: String

) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}