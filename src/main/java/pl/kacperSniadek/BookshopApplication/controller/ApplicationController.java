package pl.kacperSniadek.BookshopApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kacperSniadek.BookshopApplication.models.Book;
import pl.kacperSniadek.BookshopApplication.models.Cart;
import pl.kacperSniadek.BookshopApplication.models.Client;
import pl.kacperSniadek.BookshopApplication.repository.BookRepository;
import pl.kacperSniadek.BookshopApplication.repository.CartRepository;
import pl.kacperSniadek.BookshopApplication.repository.ClientRepository;

import java.util.List;

@Controller
public class ApplicationController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/")
    public String homeGet(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "index";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Long bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            Cart cartItem = new Cart();
            cartItem.setBookId(book.getId());
            cartItem.setBookTitle(book.getTitle());
            cartItem.setBookAuthor(book.getAuthor());
            cartItem.setBookYear(book.getYear());
            cartItem.setBookPrice(book.getPrice());
            cartRepository.save(cartItem);
        }
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<Cart> cartItems = cartRepository.findAll();
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/remove-from-cart/{cartItemId}")
    public String removeFromCart(@PathVariable Long cartItemId) {
        cartRepository.deleteById(cartItemId);
        return "redirect:/cart";
    }

    @GetMapping("/order")
    public String order(Model model) {
        List<Cart> cartItems = cartRepository.findAll();

        int totalQuantity = 0;
        double totalPrice = 0.0;

        for (Cart cartItem : cartItems) {
            totalQuantity += 1;
            totalPrice += cartItem.getBookPrice();
        }

        model.addAttribute("totalQuantity", totalQuantity);
        model.addAttribute("totalPrice", totalPrice);

        return "order";
    }

    @PostMapping("/order")
    public String postOrder(@RequestParam String name, @RequestParam String lastname, @RequestParam String address, @RequestParam String phoneNumber) {
        Client client = new Client();
        client.setName(name);
        client.setLastname(lastname);
        client.setAddress(address);
        client.setPhoneNumber(phoneNumber);

        clientRepository.save(client);

        return "redirect:/home";
    }

}
