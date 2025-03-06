package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment3.models.Book
import com.example.assignment3.repositories.BooksRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel(
    private val BooksRepository: BooksRepository
) : ViewModel() {
    private val _books = MutableStateFlow(emptyList<Book>())
    val books: StateFlow<List<Book>> = _books

    fun getAllBooks() {
        viewModelScope.launch {
            BooksRepository.getAllBooks()
        }
    }

    fun getBookById(id: Long): Book? {
        viewModelScope.launch {
            BooksRepository.getBookById(id)
        }
    }

    init {
        viewModelScope.launch {
            BooksRepository.Book.collect{
                _books.value = it
            }
        }
    }

}