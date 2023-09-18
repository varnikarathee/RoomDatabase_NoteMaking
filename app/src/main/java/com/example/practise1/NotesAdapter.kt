package com.example.practise1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(val context: Context, private val listener: INotesAdapter) :RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    val allNotes = ArrayList<Note>()
    inner class NotesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        TODO("Not yet implemented")
        val viewHolder = NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_item_notes,parent,false))
        viewHolder.deleteButton.setOnClickListener{
            listener.OnItemClicked(allNotes[viewHolder.adapterPosition])

        }

        return viewHolder

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        return allNotes.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        TODO("Not yet implemented")
        val currentNote = allNotes[position]
        holder.textView.text=currentNote.text

    }
    //data observed by viewholder , ie changed dta will be updated.
    fun updateList(newList:List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }
}
    interface INotesAdapter {
        fun OnItemClicked(Note:Note)
    }


