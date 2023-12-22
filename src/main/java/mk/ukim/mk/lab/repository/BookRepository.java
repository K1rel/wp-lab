package mk.ukim.mk.lab.repository;


import mk.ukim.mk.lab.model.Author;
import mk.ukim.mk.lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

   Optional<Book> findBookByIsbn(String isbn);

}
