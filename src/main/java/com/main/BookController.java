package com.main;

import com.main.mapper.BookToDtoMapper;
import com.main.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/books") //контроллер будет обрабатывать HTTP-запросы
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookToDtoMapper mapper;

    //Получение книги по идентификатору
    @GetMapping("/{id}") //Добавление в метод get с передаваемым id
    public Book getBookById(@PathVariable Long id) {
                            //извлекает шаблонную часть url
        return bookService.getBookById(id);
    }
    //Получение списка всех книг
    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String author) {
        if (author != null) //если не передаем в кач-ве параметра автора книги, то показать весь список
            return bookService.findByAuthor(author);

        return bookService.getAllBooks();
    }
    //Добавление книги
    @PostMapping //Добавление в метод post
    public void addBook(@RequestBody BookRequest request) {
                       //преобразовывает содержимое тела входящего запроса в объект
        bookService.addBook(mapper.AddBookRequestToBook(request));
    }
}
