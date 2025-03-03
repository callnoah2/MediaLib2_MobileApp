package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment3.models.Movie
import com.example.assignment3.repositories.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _movies = MutableStateFlow(emptyList<Movie>())
    val movies: StateFlow<List<Movie>> = _movies

    init {
        viewModelScope.launch {
            MoviesRepository.Movies.collect{
                _movies.value = it
            }
        }
    }

    fun getMovieById(id: Int): Movie? {
        return _movies.value.find { it.id == id }
    }

    fun getNextId(): Int {
        return _movies.value.maxOfOrNull { it.id }?.plus(1) ?: 0
    }
}