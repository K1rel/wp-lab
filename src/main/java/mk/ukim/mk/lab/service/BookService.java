package mk.ukim.mk.lab.service;

import mk.ukim.mk.lab.model.Author;
import mk.ukim.mk.lab.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listBooks();
    void addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
    Book findBookById(Long id);

    void transferDataToDatabase();
    void addBook(Book book);
    void deleteBook(Book book);
}
