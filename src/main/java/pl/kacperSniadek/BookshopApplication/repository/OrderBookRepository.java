package pl.kacperSniadek.BookshopApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kacperSniadek.BookshopApplication.model.OrderBook;
@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {
}
