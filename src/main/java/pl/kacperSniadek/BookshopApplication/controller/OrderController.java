package pl.kacperSniadek.BookshopApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kacperSniadek.BookshopApplication.Cart;
import pl.kacperSniadek.BookshopApplication.dto.OrderDto;
import pl.kacperSniadek.BookshopApplication.model.Book;
import pl.kacperSniadek.BookshopApplication.repository.BookRepository;
import pl.kacperSniadek.BookshopApplication.repository.OrderRepository;
import pl.kacperSniadek.BookshopApplication.service.OrderService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final BookRepository bookRepository;
    private final Cart cart;
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @Autowired
    public OrderController(BookRepository bookRepository, Cart cart, OrderRepository orderRepository, OrderService orderService) {
        this.bookRepository = bookRepository;
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
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
    @GetMapping("/summary")
    public String summary() {
        return "summary";
    }
    @PostMapping("/saveOrder")
    public String saveOrder(OrderDto orderDto) {
        orderService.saveOrder(orderDto);
        return "redirect:/";
    }
}
