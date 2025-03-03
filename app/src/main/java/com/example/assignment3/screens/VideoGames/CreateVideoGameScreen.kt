package com.example.assignment3.screens.VideoGames

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.assignment3.models.VideoGame
import com.example.assignment3.repositories.VideoGamesRepository
import com.example.assignment3.viewModels.VideoGameViewModel
import com.example.assignment3.viewModels.MainViewModel

@Composable
fun CreateVideoGameScreen(
    navController: NavController,
    viewModel: VideoGameViewModel = VideoGameViewModel(),
    mainViewModel: MainViewModel = MainViewModel(),
    repository: VideoGamesRepository = VideoGamesRepository) {
    var title by remember { mutableStateOf("") }
    var developer by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var platform by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = "Add Video Game",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = developer,
            onValueChange = { developer = it },
            label = { Text("Developer") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = genre,
            onValueChange = { genre = it },
            label = { Text("Genre") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = rating,
            onValueChange = { rating = it },
            label = { Text("Rating") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = platform,
            onValueChange = { platform = it },
            label = { Text("Platform") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text("Notes") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (title.isNotEmpty()) {
                    val newVideoGame = VideoGame(
                        id = viewModel.getNextId(),
                        title = title,
                        developer = developer,
                        genre = genre,
                        rating = rating,
                        platform = platform,
                        notes = notes
                    )
                    repository.addVideoGame(newVideoGame.title, newVideoGame.developer, newVideoGame.genre, newVideoGame.rating, newVideoGame.platform, newVideoGame.notes)
                    mainViewModel.incrementVideoGameCount()
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Save Video Game")
        }
    }
}