package com.example.assignment3.repositories

import com.example.assignment3.models.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object BooksRepository {
    var bookId = 0
    private val _Book = MutableStateFlow(emptyList<Book>())
    val Book: StateFlow<List<Book>> = _Book

    fun addBook(
        title: String,
        author: String,
        format: String,
        numPages: Int,
        genre: String,
        notes: String
    ) {
        val newBook = Book(
            id = ++bookId,
            title = title,
            author = author,
            format = format,
            numPages = numPages,
            genre = genre,
            notes = notes
        )

        _Book.value += newBook
    }
    fun updateBook(
        id: Int,
        title: String,
        author: String,
        format: String,
        numPages: Int,
        genre: String,
        notes: String,
    ) {
        val updatedBook = Book(
            id = id,
            title = title,
            author = author,
            format = format,
            numPages = numPages,
            genre = genre,
            notes = notes
        )

        _Book.value = _Book.value.map { book ->
            if (book.id == id) {
                updatedBook
            } else {
                book
            }
        }
    }
}