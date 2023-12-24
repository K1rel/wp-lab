package mk.ukim.mk.lab.service.impl;

import mk.ukim.mk.lab.bootstrap.DataHolder;
import mk.ukim.mk.lab.model.Book;
import mk.ukim.mk.lab.model.BookStore;
import mk.ukim.mk.lab.repository.BookStoreRepository;
import mk.ukim.mk.lab.service.BookStoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookStoreImpl implements BookStoreService {
    private final BookStoreRepository bookStoreRepository;

    public BookStoreImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }

    @Override
    public void transferDataToDatabase() {
        List<BookStore> bookStores = DataHolder.bookStores;
        for(BookStore dhBookStore : bookStores ){
            BookStore bookStore = new BookStore();
            bookStore.setName(dhBookStore.getName());
            bookStore.setAddress(dhBookStore.getAddress());
            bookStore.setCity(dhBookStore.getCity());
            bookStore.setBooks(dhBookStore.getBooks());
            bookStoreRepository.save(bookStore);
        }

    }
}
