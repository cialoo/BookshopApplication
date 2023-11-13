package pl.kacperSniadek.BookshopApplication.mapper;

import pl.kacperSniadek.BookshopApplication.Cart;
import pl.kacperSniadek.BookshopApplication.CartBook;
import pl.kacperSniadek.BookshopApplication.dto.OrderDto;
import pl.kacperSniadek.BookshopApplication.model.Order;
import pl.kacperSniadek.BookshopApplication.model.OrderBook;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static Order mapToOrder(OrderDto orderDto) {
        return Order.builder()
                .firstName(orderDto.getFirstName())
                .lastName(orderDto.getLastName())
                .address(orderDto.getAddress())
                .postCode(orderDto.getPostCode())
                .city(orderDto.getCity())
                .created(LocalDateTime.now())
                .build();
    }
    public static List<OrderBook> mapToOrderBookList(Cart cart, Order order) {
        List<OrderBook> orderBooks = new ArrayList<>();
        for(CartBook cartBook: cart.getCartBooks()) {
            orderBooks.add(new OrderBook(order.getOrderId(), cartBook.getBook().getId(), cartBook.getCounter()));
        }
        return orderBooks;
    }
}
