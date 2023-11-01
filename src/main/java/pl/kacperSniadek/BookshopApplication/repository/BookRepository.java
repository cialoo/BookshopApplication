package pl.kacperSniadek.BookshopApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kacperSniadek.BookshopApplication.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
