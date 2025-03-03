package com.example.assignment3.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController, movieCount: Int, bookCount: Int, gameCount: Int, boardGameCount: Int) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Media Gallery", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        ButtonWithCount("Movies", movieCount) { navController.navigate("movies") }
        ButtonWithCount("Books", bookCount) { navController.navigate("books") }
        ButtonWithCount("Video Games", gameCount) { navController.navigate("video_games") }
        ButtonWithCount("Board Games", boardGameCount) { navController.navigate("board_games") }
    }
}

@Composable
fun ButtonWithCount(label: String, count: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        Text(text = "$label ($count)")
    }
}
