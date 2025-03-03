package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.assignment3.ui.theme.Assignment3Theme
import com.example.assignment3.screens.HomeScreen
import com.example.assignment3.screens.Movies.MovieScreen
import com.example.assignment3.screens.Movies.CreateMovieScreen
import com.example.assignment3.screens.Movies.MovieDetailScreen
import com.example.assignment3.screens.Books.BookScreen
import com.example.assignment3.screens.Books.CreateBookScreen
import com.example.assignment3.screens.Books.BookDetailScreen
import com.example.assignment3.screens.VideoGames.VideoGameScreen
import com.example.assignment3.screens.VideoGames.CreateVideoGameScreen
import com.example.assignment3.screens.VideoGames.VideoGameDetailScreen
import com.example.assignment3.screens.BoardGames.BoardGameScreen
import com.example.assignment3.screens.BoardGames.CreateBoardGameScreen
import com.example.assignment3.screens.BoardGames.BoardGameDetailScreen
import androidx.navigation.compose.composable
import com.example.assignment3.repositories.BoardGamesRepository
import com.example.assignment3.repositories.BooksRepository
import com.example.assignment3.repositories.MoviesRepository
import com.example.assignment3.repositories.VideoGamesRepository


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment3Theme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = "home"
                        ) {
                            // HOME
                            composable("home") {
                                HomeScreen(
                                    movieCount = MoviesRepository.movieId,
                                    bookCount = BooksRepository.bookId,
                                    gameCount = VideoGamesRepository.videoGameId,
                                    boardGameCount = BoardGamesRepository.boardGameId,
                                    navController = navController
                                )
                            }
                            //MOVIES
                            composable("movies") {
                                MovieScreen(navController = navController)
                            }
                            composable("create_movie") {
                                CreateMovieScreen(navController = navController)
                            }
                            composable("movie_detail/{movieId}") { backStackEntry ->
                                val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull() ?: 0
                                MovieDetailScreen(
                                    movieId = movieId,
                                    navController = navController
                                )
                            }
                            //BOOKS
                            composable("books") {
                                BookScreen(navController = navController)
                            }
                            composable("create_book") {
                                CreateBookScreen(navController = navController)
                            }
                            composable("book_detail/{bookId}") { backStackEntry ->
                                val bookId = backStackEntry.arguments?.getString("bookId")?.toIntOrNull() ?: 0
                                BookDetailScreen(
                                    bookId = bookId,
                                    navController = navController
                                )
                            }
                            //VIDEO GAMES
                            composable("video_games") {
                                VideoGameScreen(navController = navController)
                            }
                            composable("create_video_game") {
                                CreateVideoGameScreen(navController = navController)
                            }
                            composable("video_game_detail/{videoGameId}") { backStackEntry ->
                                val videoGameId = backStackEntry.arguments?.getString("videoGameId")?.toIntOrNull() ?: 0
                                VideoGameDetailScreen(
                                    videoGameId = videoGameId,
                                    navController = navController
                                )
                            }
                            //BOARD GAMES
                            composable("board_games") {
                                BoardGameScreen(navController = navController)
                            }
                            composable("create_board_game") {
                                CreateBoardGameScreen(navController = navController)
                            }
                            composable("board_game_detail/{boardGameId}") { backStackEntry ->
                                val boardGameId = backStackEntry.arguments?.getString("boardGameId")?.toIntOrNull() ?: 0
                                BoardGameDetailScreen(
                                    boardGameId = boardGameId,
                                    navController = navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}