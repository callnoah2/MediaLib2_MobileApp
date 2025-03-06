package com.example.assignment3.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.assignment3.models.Book


@Dao
abstract class BooksDao {
    @Query("SELECT * FROM Book")
    abstract suspend fun getAllBooks(): List<Book>

    @Insert
    abstract suspend fun insertBook(book: Book): Long

    @Query("SELECT * FROM Book WHERE id = :id")
    abstract suspend fun getBookById(id: Int): Book?

    @Update
    abstract suspend fun updateBook(book: Book)
}
