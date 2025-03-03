package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.assignment3.models.VideoGame
import com.example.assignment3.repositories.VideoGamesRepository

class VideoGameViewModel : ViewModel() {
    private val _videoGames = MutableStateFlow(emptyList<VideoGame>())
    val videoGames: StateFlow<List<VideoGame>> = _videoGames

    init {
        viewModelScope.launch {
            VideoGamesRepository.VideoGames.collect {
                _videoGames.value = it
            }
        }
    }

    fun getVideoGameById(id: Int): VideoGame? {
        return _videoGames.value.find { it.id == id }
    }

    fun getNextId(): Int {
        return _videoGames.value.maxOfOrNull { it.id }?.plus(1) ?: 0
    }
}