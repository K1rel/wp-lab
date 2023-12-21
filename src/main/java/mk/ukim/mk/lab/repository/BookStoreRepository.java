package mk.ukim.mk.lab.repository;

import mk.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookStoreRepository {
    List<BookStore> bookStores = new ArrayList<>();
    public BookStoreRepository() {

        BookStore bookStore1 = new BookStore(1L, "Bookstore A", "City A", "Address A");
        BookStore bookStore2 = new BookStore(2L, "Bookstore B", "City B", "Address B");
        BookStore bookStore3 = new BookStore(3L, "Bookstore C", "City C", "Address C");
        BookStore bookStore4 = new BookStore(4L, "Bookstore D", "City D", "Address D");
        BookStore bookStore5 = new BookStore(5L, "Bookstore E", "City E", "Address E");

        bookStores= Arrays.asList(bookStore1, bookStore2, bookStore3, bookStore4, bookStore5);
    }

    public List<BookStore> findAll(){
        return bookStores;
    }



}
