package com.example.assignment3

import android.app.Application
import androidx.room.Room
import com.example.assignment3.repositories.BoardGamesRepository

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
}