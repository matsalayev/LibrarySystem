package uz.books.librarysystem.service;

import uz.books.librarysystem.dtos.BookDto;
import uz.books.librarysystem.model.Book;
import java.util.List;

public interface BookService {
    void save(BookDto book);
    void delete(Integer id);
    List<BookDto> findAllBook();
    List<BookDto> search(String keyword);
    BookDto find(Integer id);
}
