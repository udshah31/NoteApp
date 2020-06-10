package com.example.noteapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.database.Notes
import com.example.noteapp.repositories.NoteRepository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: NoteRepository
) : ViewModel() {
    fun insert(notes: Notes) = viewModelScope.launch {
        repository.insert(notes)
    }

    fun update(notes: Notes) = viewModelScope.launch {
        repository.update(notes)
    }

    fun delete(notes: Notes) = viewModelScope.launch {
        repository.delete(notes)
    }

    fun getAllNotes() = repository.getAllNotes()
}