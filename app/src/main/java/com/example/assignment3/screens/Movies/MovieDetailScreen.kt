package com.example.assignment3.screens.Movies

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewModels.MovieViewModel

@Composable
fun MovieDetailScreen(navController: NavController, movieId: Int, viewModel: MovieViewModel = viewModel()) {
    val movie = viewModel.getMovieById(movieId)
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
                if (movie != null) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = movie.title, style = MaterialTheme.typography.headlineLarge)
                        Text(
                            text = "Genre: ${movie.genre}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Rating: ${movie.rating}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Runtime: ${movie.runtime} minutes",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Format: ${movie.format}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Notes: ${movie.notes}",
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