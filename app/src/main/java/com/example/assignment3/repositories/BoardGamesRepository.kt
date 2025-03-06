package com.example.assignment3.repositories

import com.example.assignment3.daos.BoardGamesDao
import com.example.assignment3.models.BoardGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BoardGamesRepository(
    private val boardGamesDao: BoardGamesDao
) {
    private val _BoardGames = MutableStateFlow(emptyList<BoardGame>())
    val BoardGames: StateFlow<List<BoardGame>> = _BoardGames

    suspend fun getAllBoardGames() {
        _BoardGames.value = boardGamesDao.getAllBoardGames()
    }

    suspend fun addBoardGame(
        title: String,
        minPlayers: Int,
        maxPlayers: Int,
        type: String,
        notes: String
    ) {
        val newBoardGame = BoardGame(
            title = title,
            minPlayers = minPlayers,
            maxPlayers = maxPlayers,
            type = type,
            notes = notes
        )
        newBoardGame.id = boardGamesDao.insertBoardGame(newBoardGame)
        _BoardGames.value += newBoardGame
    }

    suspend fun getBoardGameById(id: Int): BoardGame? {
        return boardGamesDao.getBoardGameById(id)
    }

//    suspend fun updateBoardGame(
//        id: Long,
//        title: String,
//        minPlayers: Int,
//        maxPlayers: Int,
//        type: String,
//        notes: String
//    ) {
//        val updatedBoardGame = BoardGame(
//            id = id,
//            title = title,
//            minPlayers = minPlayers,
//            maxPlayers = maxPlayers,
//            type = type,
//            notes = notes
//        )
//
//        _BoardGames.value = _BoardGames.value.map { boardGame ->
//            if (boardGame.id == id) {
//                updatedBoardGame
//            } else {
//                boardGame
//            }
//        }
//    }
    companion object {
    }
}