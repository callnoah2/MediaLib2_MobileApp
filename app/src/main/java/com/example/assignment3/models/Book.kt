package com.example.assignment3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Book(
    @PrimaryKey var id: Long? = null,
    @ColumnInfo val title: String,
    @ColumnInfo val author: String,
    @ColumnInfo val format: String, // paperback, hardback, e-book, audio-book
    @ColumnInfo val numPages: Int,
    @ColumnInfo val genre: String,
    @ColumnInfo val notes: String
)