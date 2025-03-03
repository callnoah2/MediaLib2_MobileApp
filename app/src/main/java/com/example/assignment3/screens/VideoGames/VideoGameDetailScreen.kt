package com.example.assignment3.screens.VideoGames

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewModels.VideoGameViewModel

@Composable
fun VideoGameDetailScreen(navController: NavController, videoGameId: Int, viewModel: VideoGameViewModel = viewModel()) {
    val game = viewModel.getVideoGameById(videoGameId)
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
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = game.title, style = MaterialTheme.typography.headlineLarge)
                        Text(
                            text = "Developer: ${game.developer}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Genre: ${game.genre}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Rating: ${game.rating}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Platform: ${game.platform} minutes",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Notes: ${game.notes}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                } else {
                    Text(text = "Movie not found", style = MaterialTheme.typography.headlineLarge)
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