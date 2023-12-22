package mk.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.mk.lab.model.Author;
import mk.ukim.mk.lab.model.Book;
import mk.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataHolder {

    public static List<Author> authors= new ArrayList<>();
    public static List<Book> books = new ArrayList<>();
    public static List<BookStore> bookStores = new ArrayList<>();

    @PostConstruct
    public void init(){
        System.out.println("Initializing data in DataHolder...");
        authors.add(new Author(1L, "John", "Doe", "Biography of John Doe"));
        authors.add(new Author(2L, "Jane", "Smith", "Biography of Jane Smith"));
        authors.add(new Author(3L, "Bob", "Johnson", "Biography of Bob Johnson"));
        authors.add(new Author(4L, "Alice", "Williams", "Biography of Alice Williams"));
        authors.add(new Author(5L, "Charlie", "Brown", "Biography of Charlie Brown"));

        BookStore bookStore1 = new BookStore(1L, "Bookstore A", "City A", "Address A");
        BookStore bookStore2 = new BookStore(2L, "Bookstore B", "City B", "Address B");
        BookStore bookStore3 = new BookStore(3L, "Bookstore C", "City C", "Address C");
        BookStore bookStore4 = new BookStore(4L, "Bookstore D", "City D", "Address D");
        BookStore bookStore5 = new BookStore(5L, "Bookstore E", "City E", "Address E");

        bookStores= Arrays.asList(bookStore1, bookStore2, bookStore3, bookStore4, bookStore5);

        Book book1 = new Book("1234567890", "Book Title 1", "Fiction", 2020, new ArrayList<>(List.of(authors.get(0), authors.get(1),authors.get(2))),bookStores.get(0));
        Book book2 = new Book("9876543210", "Book Title 2", "Non-Fiction", 2018,  new ArrayList<>(List.of(authors.get(2), authors.get(1))),bookStores.get(1));
        Book book3 = new Book("5555555555", "Book Title 3", "Mystery", 2015,  new ArrayList<>(List.of(authors.get(3), authors.get(4))),bookStores.get(2));
        Book book4 = new Book("1111111111", "Book Title 4", "Science Fiction", 2022,  new ArrayList<>(List.of(authors.get(0), authors.get(1))),bookStores.get(3));
        Book book5 = new Book("9999999999", "Book Title 5", "Thriller", 2017,  new ArrayList<>(List.of(authors.get(0), authors.get(1),authors.get(2))),bookStores.get(4));

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
    }

}
