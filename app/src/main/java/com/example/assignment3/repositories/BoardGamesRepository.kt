package com.example.assignment3.repositories

import com.example.assignment3.models.BoardGame
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object BoardGamesRepository {
    var boardGameId = 0
    private val _BoardGames = MutableStateFlow(emptyList<BoardGame>())
    val BoardGames: StateFlow<List<BoardGame>> = _BoardGames

    fun addBoardGame(
        title: String,
        minPlayers: Int,
        maxPlayers: Int,
        type: String,
        notes: String
    ) {
        val newBoardGame = BoardGame(
            id = ++boardGameId,
            title = title,
            minPlayers = minPlayers,
            maxPlayers = maxPlayers,
            type = type,
            notes = notes
        )

        _BoardGames.value += newBoardGame
    }

    fun updateBoardGame(
        id: Int,
        title: String,
        minPlayers: Int,
        maxPlayers: Int,
        type: String,
        notes: String
    ) {
        val updatedBoardGame = BoardGame(
            id = id,
            title = title,
            minPlayers = minPlayers,
            maxPlayers = maxPlayers,
            type = type,
            notes = notes
        )

        _BoardGames.value = _BoardGames.value.map { boardGame ->
            if (boardGame.id == id) {
                updatedBoardGame
            } else {
                boardGame
            }
        }
    }
}