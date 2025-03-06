package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.assignment3.models.VideoGame
import com.example.assignment3.repositories.VideoGamesRepository

class VideoGameViewModel(
    private val VideoGamesRepository: VideoGamesRepository
) : ViewModel() {
    private val _videoGames = MutableStateFlow(emptyList<VideoGame>())
    val videoGames: StateFlow<List<VideoGame>> = _videoGames

    private val _videoGame = MutableStateFlow<VideoGame?>(null)
    val videoGame: StateFlow<VideoGame?> = _videoGame


    fun getAllVideoGames() {
        viewModelScope.launch {
            VideoGamesRepository.getAllVideoGames()
        }
    }

    fun fetchVideoGameById(id: Long) {
        viewModelScope.launch {
            _videoGame.value = VideoGamesRepository.getVideoGameById(id)
        }
    }

    init {
        viewModelScope.launch {
            VideoGamesRepository.VideoGames.collect {
                _videoGames.value = it
            }
        }
    }

}