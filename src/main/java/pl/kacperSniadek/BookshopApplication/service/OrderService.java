package pl.kacperSniadek.BookshopApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kacperSniadek.BookshopApplication.Cart;
import pl.kacperSniadek.BookshopApplication.dto.OrderDto;
import pl.kacperSniadek.BookshopApplication.mapper.OrderMapper;
import pl.kacperSniadek.BookshopApplication.model.Order;
import pl.kacperSniadek.BookshopApplication.model.OrderBook;
import pl.kacperSniadek.BookshopApplication.repository.OrderBookRepository;
import pl.kacperSniadek.BookshopApplication.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    private final Cart cart;
    private final OrderRepository orderRepository;
    private final OrderBookRepository orderBookRepository;
    @Autowired
    public OrderService(Cart cart, OrderRepository orderRepository, OrderBookRepository orderBookRepository) {
        this.cart = cart;
        this.orderRepository = orderRepository;
        this.orderBookRepository = orderBookRepository;
    }

    public void saveOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        orderRepository.save(order);
        orderBookRepository.saveAll(OrderMapper.mapToOrderBookList(cart, order));
        cart.clearCart();
    }
}
