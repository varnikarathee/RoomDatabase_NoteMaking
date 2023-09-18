package com.example.practise1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application, private val repository: NotesRepository) :AndroidViewModel(application) {

    val allNotes:LiveData<List<Note>>
    init{
        val dao = NotesDatabase.getDatabase(application).Notes_Dao()
        val repository= NotesRepository(dao)
        allNotes=repository.allNotes
    }
   //viewmodelscoper.launch (Dispatcher.io) is used to call coroutines(A background thread).
    //dispatcher.io tells input/output function
    //suspend function from suspend call or coroutibne only.
    //viewmodel makes call to repository
    fun deleteNote(note:Note)= viewModelScope.launch(Dispatchers.IO){
        //access repository
        repository.delete(note)

    }
    fun insertNote(note:Note)=viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }



}