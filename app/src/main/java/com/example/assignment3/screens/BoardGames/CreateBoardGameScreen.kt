package com.example.assignment3.screens.BoardGames

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.room.Room
import com.example.assignment3.AppDataBase
import com.example.assignment3.models.BoardGame
import com.example.assignment3.viewModels.BoardGameViewModel
import com.example.assignment3.viewModels.MainViewModel
import com.example.assignment3.repositories.BoardGamesRepository
import com.example.assignment3.daos.BoardGamesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CreateBoardGameScreen(
    navController: NavController,
//    viewModel: BoardGameViewModel = BoardGameViewModel(BoardGamesRepository(boardGamesDao = BoardGamesDao)),
    mainViewModel: MainViewModel = MainViewModel(),
//    repository: BoardGamesRepository = BoardGamesRepository
) {
    var title by remember { mutableStateOf("") }
    var minPlayers by remember { mutableStateOf(1) }
    var maxPlayers by remember { mutableStateOf(4) }
    var type by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val db = Room.databaseBuilder(
        LocalContext.current,
        AppDataBase::class.java,
        "media_library"
    ).build()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(
            text = "Add Board Game",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = minPlayers.toString(),
            onValueChange = { minPlayers = it.toIntOrNull() ?: 1 },
            label = { Text("Min Players") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = maxPlayers.toString(),
            onValueChange = { maxPlayers = it.toIntOrNull() ?: 4 },
            label = { Text("Max Players") },
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = type,
            onValueChange = { type = it },
            label = { Text("Type") },
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
                scope.launch(Dispatchers.IO) {
                        if (title.isNotEmpty()) {
                            val newBoardGame = BoardGame(
                                title = title,
                                minPlayers = minPlayers,
                                maxPlayers = maxPlayers,
                                type = type,
                                notes = notes
                            )
                            db.boardGamesDao.insertBoardGame(newBoardGame)
//                            repository.addBoardGame(newBoardGame.title, newBoardGame.minPlayers, newBoardGame.maxPlayers, newBoardGame.type, newBoardGame.notes)
//                            Log.d("CreateBoardGameScreen", "New BoardGame added: $newBoardGame")
                            mainViewModel.incrementBoardGameCount()
                            navController.popBackStack()
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
            ) {
                Text("Save Board Game")
            }
    }
}