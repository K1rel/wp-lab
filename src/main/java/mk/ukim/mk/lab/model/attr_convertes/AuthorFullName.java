package mk.ukim.mk.lab.model.attr_convertes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AuthorFullName implements Serializable {
    private String name;
    private String surname;

    public AuthorFullName() {
        this.name = "";
        this.surname = "";
    }
}
