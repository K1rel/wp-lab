package mk.ukim.mk.lab.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Random;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer score;
    private String description;

    @ManyToOne
    private Book book;
    private LocalDateTime timestamp;

    public Review(Integer score, String description, Book book, LocalDateTime timestamp) {
        this.id = new Random().nextLong(0,10000) + 1;
        this.score = score;
        this.description = description;
        this.book = book;
        this.timestamp = timestamp;
    }

    public Review() {

    }
}
