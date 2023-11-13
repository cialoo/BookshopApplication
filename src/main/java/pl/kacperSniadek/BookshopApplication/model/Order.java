package pl.kacperSniadek.BookshopApplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postCode;
    private LocalDateTime created;
    @OneToMany
    @JoinColumn(name = "orderId")
    private List<OrderBook> orderBooks;
}
