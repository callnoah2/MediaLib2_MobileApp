package com.example.assignment3.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.assignment3.models.Movie

@Dao
abstract class MoviesDao {
    @Query("SELECT * FROM Movie")
    abstract suspend fun getAllMovies(): List<Movie>

    @Insert
    abstract suspend fun insertMovie(movie: Movie): Long

    @Query("SELECT * FROM Movie WHERE id = :id")
    abstract suspend fun getMovieById(id: Int): Movie?

    @Update
    abstract suspend fun updateMovie(movie: Movie)
}