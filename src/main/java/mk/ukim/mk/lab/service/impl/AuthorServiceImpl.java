package mk.ukim.mk.lab.service.impl;


import mk.ukim.mk.lab.bootstrap.DataHolder;
import mk.ukim.mk.lab.model.Author;
import mk.ukim.mk.lab.model.Book;
import mk.ukim.mk.lab.repository.AuthorRepository;
import mk.ukim.mk.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public void transferDataToDatabase() {
        List<Author> authors = DataHolder.authors;
        for(Author dhAuthor : authors){
            Author author = new Author();
            author.setName(dhAuthor.getName());
            author.setSurname(dhAuthor.getSurname());
            author.setBiography(dhAuthor.getBiography());
            author.setDateOfBirth(dhAuthor.getDateOfBirth());
            author.setBook(dhAuthor.getBook());

            authorRepository.save(author);
        }
    }
}
