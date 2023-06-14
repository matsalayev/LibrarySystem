package uz.books.librarysystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.books.librarysystem.dtos.BookDto;
import uz.books.librarysystem.model.Book;
import uz.books.librarysystem.service.BookService;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("book", new BookDto());
        return "create";
    }
    @GetMapping
    public String index(Model model) {
        model.addAttribute("Books", service.findAllBook());
        return "index";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("book", service.find(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("book") BookDto book) {
        service.update(book.getId(), book);
        return "redirect:/books";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("book") BookDto book) {
        service.create(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, @ModelAttribute("book") BookDto book){
        service.delete(id);
        return "redirect:/books";
    }

}
