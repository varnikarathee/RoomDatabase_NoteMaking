package com.example.practise1

import androidx.lifecycle.LiveData

class NotesRepository(private val Notes_Dao:Notes_Dao) {
    val allNotes: LiveData<List<Note>> = Notes_Dao.getAllNotes()

    suspend fun insert(note:Note){
        Notes_Dao.insert(note)
    }
    suspend fun delete(note: Note){
        Notes_Dao.delete(note)
    }
}