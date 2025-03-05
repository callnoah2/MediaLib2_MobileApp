package com.example.assignment3

import android.app.Application
import androidx.room.Room
import com.example.assignment3.repositories.BoardGamesRepository
import com.example.assignment3.repositories.BooksRepository
import com.example.assignment3.repositories.MoviesRepository
import com.example.assignment3.repositories.VideoGamesRepository

class MediaLibApplication: Application() {
    private val db by lazy {
        Room.databaseBuilder(
            this,
            AppDataBase::class.java,
            "media_library"
        ).build()
    }
    val boardGamesRepository by lazy {
        BoardGamesRepository(db.boardGamesDao)
    }
    val moviesRepository by lazy {
        MoviesRepository(db.moviesDao)
    }
    val booksRepository by lazy {
        BooksRepository(db.booksDao)
    }
    val videoGamesRepository by lazy {
        VideoGamesRepository(db.videoGamesDao)
    }
}