package pl.kacperSniadek.BookshopApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kacperSniadek.BookshopApplication.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
