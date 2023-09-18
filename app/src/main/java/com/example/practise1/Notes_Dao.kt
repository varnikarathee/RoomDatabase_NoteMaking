package com.example.practise1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Notes_Dao {

    //creating functions , now you want insert delete to occur aty background so that it doesn't interfere main thread . use lightweight threads = coroutines.
    @Insert(onConflict = OnConflictStrategy.FAIL)
    suspend fun insert(note:Note)


    @Delete
    suspend fun delete(note: Note)
   // nowto make it livedata so that changes will be observable by UI
    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>
}