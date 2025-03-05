package com.example.assignment3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VideoGame(
    @PrimaryKey var id: Long? = null,
    @ColumnInfo val title: String,
    @ColumnInfo val developer: String,
    @ColumnInfo val genre: String,
    @ColumnInfo val rating: String,
    @ColumnInfo val platform: String, // PC, PlayStation, Switch, Xbox, etc.
    @ColumnInfo val notes: String
)