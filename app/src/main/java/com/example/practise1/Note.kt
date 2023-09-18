package com.example.practise1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//creating table and its columns
@Entity(tableName ="notes_table")
class Note(@ColumnInfo(name = "text")val text:String) {
    @PrimaryKey(autoGenerate=true) var id =0
}