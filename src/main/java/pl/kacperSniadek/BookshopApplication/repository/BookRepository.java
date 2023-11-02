package pl.kacperSniadek.BookshopApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kacperSniadek.BookshopApplication.models.Book;
import pl.kacperSniadek.BookshopApplication.models.Cart;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();

}
