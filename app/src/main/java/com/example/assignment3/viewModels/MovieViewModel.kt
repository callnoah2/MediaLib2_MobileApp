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

    fun getAllMovies() {
        viewModelScope.launch {
            MoviesRepository.getAllMovies()
        }
    }

    fun getMovieById(id: Long): Movie? {
        viewModelScope.launch {
            MoviesRepository.getMovieById(id)
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