package com.main.service;

import com.main.Book;
import java.util.List;

public interface BookService {
    // получить книгу по id
    Book getBookById(Long id);
    // получить список всех книг
    List<Book> getAllBooks();
    // добавить книгу
    void addBook(Book book);
}
