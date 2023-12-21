package mk.ukim.mk.lab.model;

import lombok.Data;

import java.util.List;

@Data
public class BookStore {
    private Long id;
    private String name;
    private String city;
    private String address;

    public BookStore(Long id, String name, String city, String address) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
    }
}
