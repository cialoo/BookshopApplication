package pl.kacperSniadek.BookshopApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kacperSniadek.BookshopApplication.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
