package com.example.assignment3.screens.BoardGames

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.models.BoardGame
import com.example.assignment3.viewModels.BoardGameViewModel

@Composable
fun BoardGameScreen(navController: NavController, viewModel: BoardGameViewModel = viewModel()) {
    val boardGames by viewModel.boardGames.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Board Games", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(16.dp)
        ) {
            items(boardGames) { game ->
                BoardGameItem(game = game, onClick = {
                    Log.d("WantedBoardGame", "game ID: ${game.id}")
                    navController.navigate("board_game_detail/${game.id}")
                })
            }
        }

        Button(
            onClick = { navController.navigate("create_board_game") },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Add Board Game")
        }
    }
}

@Composable
fun BoardGameItem(game: BoardGame, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .clickable(onClick = onClick)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = game.title, style = MaterialTheme.typography.bodyLarge)
        }
    }
}