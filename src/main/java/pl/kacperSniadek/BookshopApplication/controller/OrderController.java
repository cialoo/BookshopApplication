package pl.kacperSniadek.BookshopApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kacperSniadek.BookshopApplication.Cart;
import pl.kacperSniadek.BookshopApplication.model.Book;
import pl.kacperSniadek.BookshopApplication.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final BookRepository bookRepository;
    private final Cart cart;

    public OrderController(BookRepository bookRepository, Cart cart) {
        this.bookRepository = bookRepository;
        this.cart = cart;
    }

    @GetMapping("/cart")
    public String showCart() {

        return "cart";
    }
    @GetMapping("/increase/{bookId}")
    public String increaseBook(@PathVariable("bookId") Long bookId, Model model) {
        Optional<Book> optBook = bookRepository.findById(bookId);
        if (optBook.isPresent()) {
            Book book = optBook.get();
            cart.addBook(book);
        }

        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);

        model.addAttribute("cartCounter", cart.getCounter());
        model.addAttribute("cartSum", cart.getSum());

        return "cart";
    }
    @GetMapping("/decrease/{bookId}")
    public String decreaseBook(@PathVariable("bookId") Long bookId, Model model) {
        Optional<Book> optBook = bookRepository.findById(bookId);
        if (optBook.isPresent()) {
            Book book = optBook.get();
            cart.removeBook(book);
        }

        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);

        model.addAttribute("cartCounter", cart.getCounter());
        model.addAttribute("cartSum", cart.getSum());

        return "cart";
    }
}
