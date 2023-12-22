package mk.ukim.mk.lab.service.impl;


import mk.ukim.mk.lab.model.Author;
import mk.ukim.mk.lab.model.Book;
import mk.ukim.mk.lab.repository.AuthorRepository;
import mk.ukim.mk.lab.repository.BookRepository;
import mk.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addAuthorToBook(Long authorId, String isbn) {
        Author avtorot = authorRepository.findById(authorId).orElse(null);
        Book knigata = bookRepository.findBookByIsbn(isbn).orElse(null);
        knigata.getAuthors().add(avtorot);
        bookRepository.save(knigata);
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn).orElse(null);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
