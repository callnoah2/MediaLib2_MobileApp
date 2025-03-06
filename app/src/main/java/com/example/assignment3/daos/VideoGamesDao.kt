package com.example.assignment3.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.assignment3.models.VideoGame

@Dao
abstract class VideoGamesDao {
    @Query("SELECT * FROM VideoGame")
    abstract suspend fun getAllVideoGames(): List<VideoGame>

    @Insert
    abstract suspend fun insertVideoGame(videoGame: VideoGame): Long

    @Query("SELECT * FROM VideoGame WHERE id = :id")
    abstract suspend fun getVideoGameById(id: Long): VideoGame?

    @Update
    abstract suspend fun updateVideoGame(videoGame: VideoGame)
}