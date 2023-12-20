package mk.ukim.mk.lab.repository;


import mk.ukim.mk.lab.model.Author;
import mk.ukim.mk.lab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    List<Book> bookList = new ArrayList<>();
 private final AuthorRepository authorRepository;
    public BookRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        Book book1 = new Book("1234567890", "Book Title 1", "Fiction", 2020, List.of(this.authorRepository.findById(1L).orElse(null), this.authorRepository.findById(2L).orElse(null)));
        Book book2 = new Book("9876543210", "Book Title 2", "Non-Fiction", 2018, List.of(this.authorRepository.findById(3L).orElse(null), this.authorRepository.findById(4L).orElse(null)));
        Book book3 = new Book("5555555555", "Book Title 3", "Mystery", 2015, List.of(this.authorRepository.findById(5L).orElse(null)));
        Book book4 = new Book("1111111111", "Book Title 4", "Science Fiction", 2022, List.of(this.authorRepository.findById(1L).orElse(null), this.authorRepository.findById(3L).orElse(null),
                this.authorRepository.findById(5L).orElse(null)));
        Book book5 = new Book("9999999999", "Book Title 5", "Thriller", 2017, List.of(this.authorRepository.findById(2L).orElse(null), this.authorRepository.findById(4L).orElse(null)));
    }

    public List<Book> findAll(){
        return bookList;
    }

    public Optional<Book> findByIsbn(String isbn){
        return bookList.stream().filter(i->i.getIsbn().equals(isbn)).findFirst();
    }

    public Author addAuthorToBook(Author author,Book book)
    {
        findByIsbn(book.getIsbn()).orElse(null).getAuthors().add(author);
        return author;
    }
}
