package mk.ukim.mk.lab.service;

import mk.ukim.mk.lab.model.Author;
import mk.ukim.mk.lab.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
}
