package com.example.assignment3.screens.BoardGames

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewModels.BoardGameViewModel

@Composable
fun BoardGameDetailScreen(navController: NavController, boardGameId: Int, viewModel: BoardGameViewModel = viewModel()) {
    val game = viewModel.getBoardGameById(boardGameId)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                if (game != null) {
                    Text(text = game.title, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 8.dp))
                    Text(text = "Players: ${game.minPlayers} - ${game.maxPlayers}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
                    Text(text = "Category: ${game.type}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
                    Text(text = "Notes: ${game.notes}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
                } else {
                    Text(text = "Game not found", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 8.dp))
                }
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
                ) {
                    Text("Back")
                }
            }
        }
    }
}