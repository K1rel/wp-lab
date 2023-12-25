package mk.ukim.mk.lab.model;


import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.mk.lab.model.attr_convertes.AuthorFullName;
import mk.ukim.mk.lab.model.attr_convertes.AuthorFullnameConverter;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.List;

@Data
@Entity

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String name;
//    private String surname;
@Convert(converter = AuthorFullnameConverter.class)
private AuthorFullName fullName;
    private String biography;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @ManyToMany
private List<Book> book;

    public Author() {
    }

    public Author(Long id, String name, String surname, String biography) {
        this.id = id;
      this.fullName =new AuthorFullName(name,surname);
        this.biography = biography;
    }


}
