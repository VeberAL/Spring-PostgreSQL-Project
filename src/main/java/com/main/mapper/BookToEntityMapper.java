package com.main.mapper;

import com.main.Book;
import com.main.dao.BookEntity;
import org.mapstruct.Mapper;
//конвертация
@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
    BookEntity bookToBookEntity(Book book);
    Book bookEntityToBook(BookEntity bookEntity);
}
