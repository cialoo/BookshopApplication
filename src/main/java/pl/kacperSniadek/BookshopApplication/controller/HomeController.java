package pl.kacperSniadek.BookshopApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kacperSniadek.BookshopApplication.model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    static List<Book> books = new ArrayList<>();
    static {
        books.add(new Book("name1", "author1", new BigDecimal("199.99")));
        books.add(new Book("name2", "author2", new BigDecimal("299.99")));
        books.add(new Book("name3", "author3", new BigDecimal("399.99")));
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", books);
        return "home";
    }
}
