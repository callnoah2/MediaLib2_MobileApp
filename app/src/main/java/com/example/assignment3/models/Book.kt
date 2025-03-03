package com.example.assignment3.models

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val format: String, // paperback, hardback, e-book, audio-book
    val numPages: Int,
    val genre: String,
    val notes: String
)