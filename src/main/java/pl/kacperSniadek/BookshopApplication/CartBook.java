package pl.kacperSniadek.BookshopApplication;

import lombok.Getter;
import pl.kacperSniadek.BookshopApplication.model.Book;

import java.math.BigDecimal;


public class CartBook {
    private Book book;
    private int counter;
    private BigDecimal price;

    public CartBook(Book book) {
        this.book = book;
        this.counter = 1;
        this.price = book.getPrice();
    }

    public Book getBook() {
        return book;
    }

    public int getCounter() {
        return counter;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void increaceCounter() {
        counter++;
        price = book.getPrice().multiply(new BigDecimal(counter));
    }
    public void decreaseCounter() {
        if(counter>0){
            counter--;
            price = book.getPrice().multiply(new BigDecimal(counter));
        }
    }
    public boolean hasZeroBook() {
        return counter ==  0;
    }

    private void recalculate() {
        price = book.getPrice().multiply(new BigDecimal(counter));
    }
}
