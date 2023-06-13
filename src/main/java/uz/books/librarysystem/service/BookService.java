package uz.books.librarysystem.service;

import uz.books.librarysystem.dtos.BookDto;
import uz.books.librarysystem.model.Book;
import java.util.List;

public interface BookService {
    void update(Integer id, BookDto item);
    void create(BookDto book);
    void delete(Integer id);
    List<BookDto> findAllBook();
    BookDto find(Integer id);
}
