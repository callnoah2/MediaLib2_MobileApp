package com.example.assignment3

import kotlinx.serialization.Serializable

object Destinations {
    @Serializable class Home
    @Serializable class Movie
    @Serializable class MovieDetail(val movieId: Int)
    @Serializable class CreateMovie
    @Serializable class Book
    @Serializable class BookDetail(val bookId: Int)
    @Serializable class CreateBook
    @Serializable class VideoGame
    @Serializable class VideoGameDetail(val videoGameId: Int)
    @Serializable class CreateVideoGame
    @Serializable class BoardGame
    @Serializable class BoardGameDetail(val boardGameId: Int)
    @Serializable class CreateBoardGame
}