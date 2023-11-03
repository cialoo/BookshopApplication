package pl.kacperSniadek.BookshopApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kacperSniadek.BookshopApplication.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
