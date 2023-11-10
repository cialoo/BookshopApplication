package pl.kacperSniadek.BookshopApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kacperSniadek.BookshopApplication.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
