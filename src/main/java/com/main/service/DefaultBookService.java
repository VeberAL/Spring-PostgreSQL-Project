package com.main.service;

import com.main.Book;
import com.main.dao.BookEntity;
import com.main.dao.BookRepository;
import com.main.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService{
    private final BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: id = " + id));

        return new Book(bookEntity.getId(),
                bookEntity.getAuthor(),
                bookEntity.getTitle(),
                bookEntity.getPrice());
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();

        ArrayList<Book> books = new ArrayList<>();
        for (BookEntity bookEntity : iterable) {
            books.add(new Book(bookEntity.getId(),
                    bookEntity.getAuthor(),
                    bookEntity.getTitle(),
                    bookEntity.getPrice()));
        }

        return books;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return null;
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = new BookEntity(null,
                book.getAuthor(),
                book.getTitle(),
                book.getPrice());
        bookRepository.save(bookEntity);
    }

    @Override
    public void editBook(Book book) {

    }
}