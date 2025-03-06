package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment3.models.Movie
import com.example.assignment3.repositories.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(
    private val MoviesRepository: MoviesRepository
) : ViewModel() {
    private val _movies = MutableStateFlow(emptyList<Movie>())
    val movies: StateFlow<List<Movie>> = _movies

    private val _movie = MutableStateFlow<Movie?>(null)
    val movie: StateFlow<Movie?> = _movie

    fun getAllMovies() {
        viewModelScope.launch {
            MoviesRepository.getAllMovies()
        }
    }

    fun fetchMovieById(id: Long) {
        viewModelScope.launch {
            _movie.value = MoviesRepository.getMovieById(id)
        }
    }

    init {
        viewModelScope.launch {
            MoviesRepository.Movies.collect{
                _movies.value = it
            }
        }
    }


}