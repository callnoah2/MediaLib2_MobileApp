package com.example.assignment3;

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.assignment3.daos.BooksDao
import com.example.assignment3.models.Book
import com.example.assignment3.models.Movie
import com.example.assignment3.models.VideoGame
import com.example.assignment3.daos.MoviesDao
import com.example.assignment3.daos.VideoGamesDao
import com.example.assignment3.daos.BoardGamesDao
import com.example.assignment3.models.BoardGame

@Database(entities = [Book::class, Movie::class, VideoGame::class, BoardGame::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract val booksDao:BooksDao
    abstract val moviesDao:MoviesDao
    abstract val videoGamesDao:VideoGamesDao
    abstract val boardGamesDao:BoardGamesDao

}