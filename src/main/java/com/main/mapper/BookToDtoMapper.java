package com.main.mapper;

import com.main.Book;
import com.main.BookRequest;
import org.mapstruct.Mapper;
//конвертация объекта AddBookRequest в объект Book
@Mapper(componentModel = "spring")
public interface BookToDtoMapper {
    Book AddBookRequestToBook(BookRequest bookRequest);
}
