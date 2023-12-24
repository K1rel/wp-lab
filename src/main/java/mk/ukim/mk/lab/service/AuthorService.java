package mk.ukim.mk.lab.service;

import mk.ukim.mk.lab.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> listAuthors();
    Author findById(Long id);
    void transferDataToDatabase();
}
