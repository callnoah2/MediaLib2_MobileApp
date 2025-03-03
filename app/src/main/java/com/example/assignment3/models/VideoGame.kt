package com.example.assignment3.models

data class VideoGame(
    val id: Int,
    val title: String,
    val developer: String,
    val genre: String,
    val rating: String,
    val platform: String, // PC, PlayStation, Switch, Xbox, etc.
    val notes: String
)