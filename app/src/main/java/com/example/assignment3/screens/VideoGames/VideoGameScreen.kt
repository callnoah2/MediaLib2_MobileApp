package com.example.assignment3.screens.VideoGames

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.models.VideoGame
import com.example.assignment3.viewModels.VideoGameViewModel

@Composable
fun VideoGameScreen(navController: NavController, viewModel: VideoGameViewModel = viewModel()) {
    val videoGames by viewModel.videoGames.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Video Games", style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(16.dp)
        ) {
            items(videoGames) { game ->
                VideoGameItem(game = game, onClick = {
                    navController.navigate("video_game_detail/${game.id}")
                })
            }
        }

        Button(
            onClick = { navController.navigate("create_video_game") },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Add Video Game")
        }
    }
}

@Composable
fun VideoGameItem(game: VideoGame, onClick: () -> Unit) {
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