package pl.kacperSniadek.BookshopApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kacperSniadek.BookshopApplication.model.Book;
import pl.kacperSniadek.BookshopApplication.repository.BookRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final BookRepository bookRepository;

    @Autowired
    public AdminController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    private String admin() {
        return "addBook";
    }
    @PostMapping
    private String addBook(Book book){
        bookRepository.save(book);
        return "redirect:/";
    }
}
