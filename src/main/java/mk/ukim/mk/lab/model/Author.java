package mk.ukim.mk.lab.model;


import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Data
@Entity

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String biography;
    private LocalDate dateOfBirth;
    @ManyToMany
private List<Book> book;

    public Author() {
    }

    public Author(Long id, String name, String surname, String biography) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.biography = biography;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
