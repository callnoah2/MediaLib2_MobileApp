package com.example.assignment3.repositories

import com.example.assignment3.models.VideoGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object VideoGamesRepository {
    var videoGameId = 0
    private val _VideoGames = MutableStateFlow(emptyList<VideoGame>())
    val VideoGames: StateFlow<List<VideoGame>> = _VideoGames

    fun addVideoGame(
        title: String,
        developer: String,
        genre: String,
        rating: String,
        platform: String,
        notes: String
    ) {
        val newVideoGame = VideoGame(

            id = ++videoGameId,
            title = title,
            developer = developer,
            genre = genre,
            rating = rating,
            platform = platform,
            notes = notes
        )

        _VideoGames.value += newVideoGame
    }

    fun updateVideoGame(
        id: Int,
        title: String,
        developer: String,
        genre: String,
        rating: String,
        platform: String,
        notes: String
    ) {
        val updatedVideoGame = VideoGame(
            id = id,
            title = title,
            developer = developer,
            genre = genre,
            rating = rating,
            platform = platform,
            notes = notes
        )

        _VideoGames.value = _VideoGames.value.map { videoGame ->
            if (videoGame.id == id) {
                updatedVideoGame
            } else {
                videoGame
            }
        }
    }
}