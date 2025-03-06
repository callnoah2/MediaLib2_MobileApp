package com.example.assignment3.repositories

import com.example.assignment3.daos.BooksDao
import com.example.assignment3.models.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BooksRepository(
    private val booksDao: BooksDao
){
    private val _Book = MutableStateFlow(emptyList<Book>())
    val Book: StateFlow<List<Book>> = _Book

    suspend fun getAllBooks() {
        _Book.value = booksDao.getAllBooks()
    }

    suspend fun addBook(
        title: String,
        author: String,
        format: String,
        numPages: Int,
        genre: String,
        notes: String
    ) {
        val newBook = Book(
            title = title,
            author = author,
            format = format,
            numPages = numPages,
            genre = genre,
            notes = notes
        )
        newBook.id = booksDao.insertBook(newBook)
        _Book.value += newBook
    }

    suspend fun getBookById(id: Long): Book? {
        return booksDao.getBookById(id)
    }
//    fun updateBook(
//        id: Long,
//        title: String,
//        author: String,
//        format: String,
//        numPages: Int,
//        genre: String,
//        notes: String,
//    ) {
//        val updatedBook = Book(
//            id = id,
//            title = title,
//            author = author,
//            format = format,
//            numPages = numPages,
//            genre = genre,
//            notes = notes
//        )
//
//        _Book.value = _Book.value.map { book ->
//            if (book.id == id) {
//                updatedBook
//            } else {
//                book
//            }
//        }
//    }
}