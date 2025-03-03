package com.example.assignment3.screens.Movies

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.models.Movie
import com.example.assignment3.repositories.MoviesRepository
import com.example.assignment3.viewModels.MainViewModel
import com.example.assignment3.viewModels.MovieViewModel

@Composable
fun CreateMovieScreen(
    navController: NavController,
    viewModel: MovieViewModel = viewModel(),
    mainViewModel: MainViewModel = MainViewModel(),
    repository: MoviesRepository = MoviesRepository
){
    var title by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var runtime by remember { mutableStateOf("") }
    var format by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Add Movie",
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
            value = runtime,
            onValueChange = { runtime = it },
            label = { Text("Runtime (minutes)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = format,
            onValueChange = { format = it },
            label = { Text("Format") },
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
                    val newMovie = Movie(
                        id = viewModel.getNextId(),
                        title = title,
                        genre = genre,
                        rating = rating,
                        runtime = runtime.toIntOrNull() ?: 0,
                        format = format,
                        notes = notes
                    )
                    repository.addMovie(newMovie.title, newMovie.genre, newMovie.rating, newMovie.runtime, newMovie.format, newMovie.notes)
                    mainViewModel.incrementMovieCount()
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Save")
        }
    }
}