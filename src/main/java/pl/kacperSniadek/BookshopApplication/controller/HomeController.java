package pl.kacperSniadek.BookshopApplication.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.kacperSniadek.BookshopApplication.Cart;
import pl.kacperSniadek.BookshopApplication.model.Book;
import pl.kacperSniadek.BookshopApplication.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final BookRepository bookRepository;
    private final Cart cart;

    @Autowired
    public HomeController(BookRepository bookRepository, Cart cart) {
        this.bookRepository = bookRepository;
        this.cart = cart;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "home";
    }

    @GetMapping("/add/{bookId}")
    public String addBookToCart(@PathVariable("bookId") Long bookId, Model model) {
        Optional<Book> optBook = bookRepository.findById(bookId);
        if (optBook.isPresent()) {
            Book book = optBook.get();
            cart.addBook(book);
        }

        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);

        model.addAttribute("cartCounter", cart.getCounter());
        model.addAttribute("cartSum", cart.getSum());

        return "home";
    }
}
