package com.main;

import com.main.mapper.BookToDtoMapper;
import com.main.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookToDtoMapper mapper;
    //Получение книги по идентификатору
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
    //Получение списка всех книг
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    //Добавление книги
    @PostMapping
    public void addBook(@RequestBody BookRequest request) {
        bookService.addBook(mapper.AddBookRequestToBook(request));
    }
}
