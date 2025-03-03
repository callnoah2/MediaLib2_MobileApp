package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.assignment3.models.BoardGame
import com.example.assignment3.repositories.BoardGamesRepository
import kotlinx.coroutines.launch

class BoardGameViewModel : ViewModel() {
    private val _boardGames = MutableStateFlow(emptyList<BoardGame>())
    val boardGames: StateFlow<List<BoardGame>> = _boardGames

    init {
        viewModelScope.launch {
            BoardGamesRepository.BoardGames.collect {
                _boardGames.value = it
            }
        }
    }

    fun getBoardGameById(id: Int): BoardGame? {
        return _boardGames.value.find { it.id == id }
    }

    fun getNextId(): Int {
        return _boardGames.value.maxOfOrNull { it.id }?.plus(1) ?: 0
    }
}