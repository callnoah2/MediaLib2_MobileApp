package com.example.assignment3.models

data class Movie(
    val id: Int,
    val title: String,
    val genre: String,
    val rating: String, // R, PG, PG-13, etc.
    val runtime: Int, // Number of minutes
    val format: String, // Digital, DVD, Blu-ray, etc.
    val notes: String // Arbitrary field for additional user information
)