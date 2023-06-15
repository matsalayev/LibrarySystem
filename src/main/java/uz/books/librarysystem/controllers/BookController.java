package uz.books.librarysystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.books.librarysystem.dtos.BookDto;
import uz.books.librarysystem.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("page","Add new book");
        model.addAttribute("book", new BookDto());
        return "input";
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("Books", service.findAllBook());
        return "index";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("page","Update book");
        model.addAttribute("book", service.find(id));
        return "input";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("book") BookDto book) {
        service.save(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, @ModelAttribute("book") BookDto book){
        service.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("keyword") String keyword, Model model){
        model.addAttribute("Books", service.search(keyword));
        return "index";
    }

}
