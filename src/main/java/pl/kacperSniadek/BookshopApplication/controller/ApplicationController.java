package pl.kacperSniadek.BookshopApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kacperSniadek.BookshopApplication.models.Book;
import pl.kacperSniadek.BookshopApplication.models.Cart;
import pl.kacperSniadek.BookshopApplication.repository.BookRepository;
import pl.kacperSniadek.BookshopApplication.repository.CartRepository;

import java.util.List;

@Controller
public class ApplicationController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;
    @GetMapping("/")
    public String listOfBooks(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "index";
    }
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam Long id) {
        Cart cart = new Cart();
        cart.setBookId(id);
        cartRepository.save(cart);
        return "redirect:/";
    }


    @GetMapping("/cart")
    public String listOfCart(Model model) {
        List<Cart> carts = cartRepository.findAll();
        model.addAttribute("carts", carts);
        return "cart";
    }
}
