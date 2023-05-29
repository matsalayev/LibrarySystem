package uz.books.librarysystem.service;

import uz.books.librarysystem.dtos.BookDto;
import uz.books.librarysystem.model.Book;
import java.util.List;

public interface BookService {
    Book update(Integer id, BookDto item);
    Book create(BookDto book);
    String delete(Integer id);
    List<BookDto> findAllBook();
}
