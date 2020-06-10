package com.example.noteapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.repositories.NoteRepository

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(
    private val noteRepository: NoteRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(noteRepository) as T
    }
}