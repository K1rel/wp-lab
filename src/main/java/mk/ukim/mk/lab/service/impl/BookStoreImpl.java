package mk.ukim.mk.lab.service.impl;

import mk.ukim.mk.lab.model.BookStore;
import mk.ukim.mk.lab.repository.BookStoreRepository;
import mk.ukim.mk.lab.service.BookStoreService;

import java.util.List;

public class BookStoreImpl implements BookStoreService {
    private final BookStoreRepository bookStoreRepository;

    public BookStoreImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public List<BookStore> findAll() {
        return bookStoreRepository.findAll();
    }
}