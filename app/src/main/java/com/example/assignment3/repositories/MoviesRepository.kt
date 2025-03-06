package com.example.assignment3.repositories

import com.example.assignment3.daos.MoviesDao
import com.example.assignment3.models.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MoviesRepository(
    private val moviesDao: MoviesDao
) {
    private val _Movies = MutableStateFlow(emptyList<Movie>())
    val Movies: StateFlow<List<Movie>> = _Movies

    suspend fun getAllMovies() {
        _Movies.value = moviesDao.getAllMovies()
    }

    suspend fun addMovie(
        title: String,
        genre: String,
        rating: String,
        runtime: Int,
        format: String,
        notes: String
    ) {
        val newMovie = Movie(
            title = title,
            genre = genre,
            rating = rating,
            runtime = runtime,
            format = format,
            notes = notes
        )
        newMovie.id = moviesDao.insertMovie(newMovie)
        _Movies.value += newMovie
    }

    suspend fun getMovieById(id: Long): Movie? {
        return moviesDao.getMovieById(id)
    }

//    fun updateMovie(
//        id: Long,
//        title: String,
//        genre: String,
//        rating: String,
//        runtime: Int,
//        format: String,
//        notes: String
//    ) {
//        val updatedMovie = Movie(
//            id = id,
//            title = title,
//            genre = genre,
//            rating = rating,
//            runtime = runtime,
//            format = format,
//            notes = notes
//        )
//
//        _Movies.value = _Movies.value.map { movie ->
//            if (movie.id == id) {
//                updatedMovie
//            } else {
//                movie
//            }
//        }
//    }
}