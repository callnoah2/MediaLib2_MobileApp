package com.example.assignment3.repositories

import com.example.assignment3.daos.VideoGamesDao
import com.example.assignment3.models.VideoGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class VideoGamesRepository(
    private val videoGamesDao: VideoGamesDao
) {
    private val _VideoGames = MutableStateFlow(emptyList<VideoGame>())
    val VideoGames: StateFlow<List<VideoGame>> = _VideoGames

    suspend fun getAllVideoGames() {
        _VideoGames.value = videoGamesDao.getAllVideoGames()
    }

    suspend fun addVideoGame(
        title: String,
        developer: String,
        genre: String,
        rating: String,
        platform: String,
        notes: String
    ) {
        val newVideoGame = VideoGame(
            title = title,
            developer = developer,
            genre = genre,
            rating = rating,
            platform = platform,
            notes = notes
        )
        newVideoGame.id = videoGamesDao.insertVideoGame(newVideoGame)
        _VideoGames.value += newVideoGame
    }

    suspend fun getVideoGameById(id: Long): VideoGame? {
        return videoGamesDao.getVideoGameById(id)
    }

//    fun updateVideoGame(
//        id: Long,
//        title: String,
//        developer: String,
//        genre: String,
//        rating: String,
//        platform: String,
//        notes: String
//    ) {
//        val updatedVideoGame = VideoGame(
//            id = id,
//            title = title,
//            developer = developer,
//            genre = genre,
//            rating = rating,
//            platform = platform,
//            notes = notes
//        )
//
//        _VideoGames.value = _VideoGames.value.map { videoGame ->
//            if (videoGame.id == id) {
//                updatedVideoGame
//            } else {
//                videoGame
//            }
//        }
//    }
}