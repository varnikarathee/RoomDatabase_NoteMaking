package com.example.practise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), INotesAdapter {
  lateinit var ViewModel:NotesViewModel
  lateinit var RecyclerView: RecyclerView
  lateinit var input:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RecyclerView=findViewById(R.id.recyclerview)
        RecyclerView.layoutManager= LinearLayoutManager(this)
        val adapter = NotesAdapter(this,this)
        RecyclerView.adapter=adapter

        ViewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NotesViewModel::class.java)
        ViewModel.allNotes.observe(this, Observer{list ->
            list?.let{
                adapter.updateList(it) //if list not null, then update
            }

        })


    }

   override fun OnItemClicked(Note:Note){
     ViewModel.deleteNote(Note)
       Toast.makeText(this, "Deleted",Toast.LENGTH_LONG).show()
   }

    fun submit(view: View) {
        input = findViewById(R.id.input)
        val notetext = input.text.toString()
        if(notetext.isNotEmpty()){
            ViewModel.insertNote(Note(notetext))
            Toast.makeText(this, "Inserted",Toast.LENGTH_LONG).show()
        }

    }
}