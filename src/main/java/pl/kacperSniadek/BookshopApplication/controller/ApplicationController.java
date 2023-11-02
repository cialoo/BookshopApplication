package pl.kacperSniadek.BookshopApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kacperSniadek.BookshopApplication.models.Book;
import pl.kacperSniadek.BookshopApplication.repository.BookRepository;

import java.util.List;

@Controller
public class ApplicationController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String homeGet(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/cart")
    public String cartGet() {
        return "cart";
    }
}
