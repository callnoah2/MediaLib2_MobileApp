package com.example.assignment3.screens.Books

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.assignment3.viewModels.BookViewModel

@Composable
fun BookDetailScreen(navController: NavController, bookId: Int, viewModel: BookViewModel = viewModel()) {
    val book = viewModel.getBookById(bookId)
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
                if (book != null) {
                    Text(text = book.title, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(bottom = 8.dp))
                    Text(text = "Author: ${book.author}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
                    Text(text = "Format: ${book.format}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
                    Text(text = "Pages: ${book.numPages}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
                    Text(text = "Genre: ${book.genre}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
                    Text(text = "Notes: ${book.notes}", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(bottom = 8.dp))
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