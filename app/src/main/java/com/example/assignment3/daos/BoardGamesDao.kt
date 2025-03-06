package com.example.assignment3.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.assignment3.models.BoardGame


@Dao
abstract class BoardGamesDao {
    @Query("SELECT * FROM BoardGame")
    abstract suspend fun getAllBoardGames(): List<BoardGame>

    @Insert
    abstract suspend fun insertBoardGame(game: BoardGame): Long

    @Query("SELECT * FROM BoardGame WHERE id = :id")
    abstract suspend fun getBoardGameById(id: Long): BoardGame?

    @Update
    abstract suspend fun updateBoardGame(boardGame: BoardGame)
}