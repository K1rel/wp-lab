package mk.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String genre;
    @Column(name = "\"year\"")
    private int year;

   @ManyToMany
    List<Author> authors;
    @ManyToOne
    private BookStore  bookStore;


    @OneToMany(mappedBy = "book")
    List<Review> reviews;

    public Book() {

    }

    public Book(String isbn, String title, String genre, int year, List<Author> authors,BookStore bookStore) {

        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.bookStore = bookStore;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
