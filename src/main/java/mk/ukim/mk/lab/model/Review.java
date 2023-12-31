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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;
    private LocalDateTime timestamp;

    public Review(Integer score, String description, Book book, LocalDateTime timestamp) {

        this.score = score;
        this.description = description;
        this.book = book;
        this.timestamp = timestamp;
    }

    public Review() {

    }
}
