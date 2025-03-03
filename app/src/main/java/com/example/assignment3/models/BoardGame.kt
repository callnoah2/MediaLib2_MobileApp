package com.example.assignment3.models

data class BoardGame(
    val id: Int,
    val title: String,
    val minPlayers: Int,
    val maxPlayers: Int,
    val type: String, // Strategy, 4X, Puzzle, Trading Card Game, Party Game, etc.
    val notes: String
)