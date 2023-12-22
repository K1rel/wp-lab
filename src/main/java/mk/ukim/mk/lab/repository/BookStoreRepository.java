package mk.ukim.mk.lab.repository;

import mk.ukim.mk.lab.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore,Long> {


}
