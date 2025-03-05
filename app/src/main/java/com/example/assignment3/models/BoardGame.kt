package com.example.assignment3.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BoardGame(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    @ColumnInfo val title: String,
    @ColumnInfo val minPlayers: Int,
    @ColumnInfo val maxPlayers: Int,
    @ColumnInfo val type: String, // Strategy, 4X, Puzzle, Trading Card Game, Party Game, etc.
    @ColumnInfo val notes: String
)