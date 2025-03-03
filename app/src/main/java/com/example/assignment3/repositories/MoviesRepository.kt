package com.example.assignment3.repositories

import com.example.assignment3.models.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object MoviesRepository {
    var movieId = 0
    private val _Movies = MutableStateFlow(emptyList<Movie>())
    val Movies: StateFlow<List<Movie>> = _Movies

    fun addMovie(
        title: String,
        genre: String,
        rating: String,
        runtime: Int,
        format: String,
        notes: String
    ) {
        val newMovie = Movie(
            id = ++movieId,
            title = title,
            genre = genre,
            rating = rating,
            runtime = runtime,
            format = format,
            notes = notes
        )

        _Movies.value += newMovie
    }

    fun updateMovie(
        id: Int,
        title: String,
        genre: String,
        rating: String,
        runtime: Int,
        format: String,
        notes: String
    ) {
        val updatedMovie = Movie(
            id = id,
            title = title,
            genre = genre,
            rating = rating,
            runtime = runtime,
            format = format,
            notes = notes
        )

        _Movies.value = _Movies.value.map { movie ->
            if (movie.id == id) {
                updatedMovie
            } else {
                movie
            }
        }
    }
}