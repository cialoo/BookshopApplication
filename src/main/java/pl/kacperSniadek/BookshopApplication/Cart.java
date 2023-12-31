package pl.kacperSniadek.BookshopApplication;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.kacperSniadek.BookshopApplication.model.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<CartBook> cartBooks = new ArrayList<>();
    private int counter = 0;
    private BigDecimal sum = BigDecimal.ZERO;

    public List<CartBook> getCartBooks() {
        return cartBooks;
    }

    public int getCounter() {
        return counter;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void addBook(Book book) {
        boolean notFound = true;
        for(CartBook cartBook1: cartBooks){
            if(cartBook1.getBook().getId().equals(book.getId())){
                notFound = false;
                cartBook1.increaceCounter();
                recalculatePriceAndCounter();
                break;
            }
        }
        if(notFound){
            cartBooks.add(new CartBook(book));
            recalculatePriceAndCounter();
        }
    }

    public void removeBook(Book book) {
        for(CartBook cartBook: cartBooks) {
            if(cartBook.getBook().getId().equals(book.getId())) {
                cartBook.decreaseCounter();
                if(cartBook.hasZeroBook()) {
                    cartBooks.remove(cartBook);
                }
                recalculatePriceAndCounter();
                break;
            }
        }
    }

    private void recalculatePriceAndCounter() {
        int tempCounter =0;
        BigDecimal tempPrice = BigDecimal.ZERO;
        for(CartBook cartBook: cartBooks) {
            tempCounter += cartBook.getCounter();
            tempPrice = tempPrice.add(cartBook.getPrice());
        }
        this.counter = tempCounter;
        this.sum = tempPrice;
    }

    public void clearCart() {
        cartBooks.clear();
        counter = 0;
        sum = BigDecimal.ZERO;
    }
}
