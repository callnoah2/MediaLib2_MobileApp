package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _movieCount = MutableStateFlow(0)
    val movieCount: StateFlow<Int> = _movieCount

    private val _bookCount = MutableStateFlow(0)
    val bookCount: StateFlow<Int> = _bookCount

    private val _videoGameCount = MutableStateFlow(0)
    val videoGameCount: StateFlow<Int> = _videoGameCount

    private val _boardGameCount = MutableStateFlow(0)
    val boardGameCount: StateFlow<Int> = _boardGameCount

    fun incrementMovieCount() {
        _movieCount.value += 1
    }

    fun incrementBookCount() {
        _bookCount.value += 1
    }

    fun incrementVideoGameCount() {
        _videoGameCount.value += 1
    }

    fun incrementBoardGameCount() {
        _boardGameCount.value += 1
    }
}