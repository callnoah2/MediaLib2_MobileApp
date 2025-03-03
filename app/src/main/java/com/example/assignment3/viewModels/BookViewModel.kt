package com.example.assignment3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment3.models.Book
import com.example.assignment3.repositories.BooksRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    private val _books = MutableStateFlow(emptyList<Book>())
    val books: StateFlow<List<Book>> = _books

    init {
        viewModelScope.launch {
            BooksRepository.Book.collect{
                _books.value = it
            }
        }
    }

    fun getBookById(id: Int): Book? {
        return _books.value.find { it.id == id }
    }

    fun getNextId(): Int {
        return _books.value.maxOfOrNull { it.id }?.plus(1) ?: 0
    }
}