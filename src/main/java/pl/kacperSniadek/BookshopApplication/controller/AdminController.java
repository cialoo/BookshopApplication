package pl.kacperSniadek.BookshopApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kacperSniadek.BookshopApplication.model.Book;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    private String admin() {
        return "addBook";
    }
    @PostMapping
    private String addBook(Book book){
        HomeController.books.add(book);
        return "redirect:/";
    }
}
