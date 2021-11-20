package com.main.service;

import com.main.Book;
import com.main.dao.BookEntity;
import com.main.dao.BookRepository;
import com.main.exceptions.BookNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService{
private final BookRepository bookRepository;
    @Override
    public Book getBookById(Long id) {                    //если значение отсутствует, то иключение
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Книга с id = " + id+" не найдена."));
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
    public void addBook(Book book) {
        BookEntity bookEntity = new BookEntity(null,
                                                book.getAuthor(),
                                                book.getTitle(),
                                                book.getPrice());
        bookRepository.save(bookEntity);
    }
}
