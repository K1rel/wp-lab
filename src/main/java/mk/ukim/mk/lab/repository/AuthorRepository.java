package mk.ukim.mk.lab.repository;


import mk.ukim.mk.lab.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {
    List<Author> authorList = new ArrayList<>();

    public AuthorRepository() {
        authorList.add(new Author(1L, "John", "Doe", "Biography of John Doe"));
        authorList.add(new Author(2L, "Jane", "Smith", "Biography of Jane Smith"));
        authorList.add(new Author(3L, "Bob", "Johnson", "Biography of Bob Johnson"));
        authorList.add(new Author(4L, "Alice", "Williams", "Biography of Alice Williams"));
        authorList.add(new Author(5L, "Charlie", "Brown", "Biography of Charlie Brown"));
    }

    public List<Author> findAll(){
        return authorList;
    }

    public Optional<Author> findById(Long id){
        return authorList.stream().filter(i->i.getId() == id).findFirst();
    }

}
