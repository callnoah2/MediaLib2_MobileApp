package com.example.assignment3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey var id: Long? = null,
    @ColumnInfo val title: String,
    @ColumnInfo val genre: String,
    @ColumnInfo val rating: String, // R, PG, PG-13, etc.
    @ColumnInfo val runtime: Int, // Number of minutes
    @ColumnInfo val format: String, // Digital, DVD, Blu-ray, etc.
    @ColumnInfo val notes: String // Arbitrary field for additional user information
)