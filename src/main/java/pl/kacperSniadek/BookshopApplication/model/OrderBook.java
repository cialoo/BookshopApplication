package pl.kacperSniadek.BookshopApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class OrderBook {
    @Id
    @GeneratedValue
    private Long orderBookId;
    private Long orderId;
    private Long bookId;
    private int amount;

    public OrderBook(Long orderId, Long bookId, int amount) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.amount = amount;
    }

}
