package com.example.assignment3.screens.Books

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.assignment3.models.Book
import com.example.assignment3.repositories.BooksRepository
import com.example.assignment3.viewModels.BookViewModel
import com.example.assignment3.viewModels.MainViewModel

@Composable
fun CreateBookScreen(
    navController: NavController,
    viewModel: BookViewModel = BookViewModel(),
    mainViewModel: MainViewModel = MainViewModel(),
    repository: BooksRepository = BooksRepository
){
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var format by remember { mutableStateOf("") }
    var numPages by remember { mutableStateOf(0) }
    var genre by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize().
        padding(16.dp)
    ) {
        Text(
            text = "Add Book",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = author,
            onValueChange = { author = it },
            label = { Text("Author") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = format,
            onValueChange = { format = it },
            label = { Text("Format") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = numPages.toString(),
            onValueChange = { numPages = it.toIntOrNull() ?: 0 },
            label = { Text("Number of Pages") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = genre,
            onValueChange = { genre = it },
            label = { Text("Genre") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text("Notes") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        Button(
            onClick = {
                if (title.isNotEmpty()) {
                    val newBook = Book(
                        id = viewModel.getNextId(),
                        title = title,
                        author = author,
                        format = format,
                        numPages = numPages,
                        genre = genre,
                        notes = notes
                    )
                    repository.addBook(newBook.title, newBook.author, newBook.format, newBook.numPages, newBook.genre, newBook.notes)
                    mainViewModel.incrementBookCount()
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Save Book")
        }
    }
}