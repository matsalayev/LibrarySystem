package uz.books.librarysystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.books.librarysystem.dtos.BookDto;
import uz.books.librarysystem.model.Book;
import uz.books.librarysystem.service.BookService;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> list() {
        return ResponseEntity.ok(service.findAllBook());
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody BookDto item) {
        return ResponseEntity.ok(service.update(id, item));
    }

    @PostMapping()
    public ResponseEntity<Book> create(@RequestBody BookDto book){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(book));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        return ResponseEntity.ok(service.delete(id));
    }

}
