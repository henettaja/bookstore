package hh.swd20.kirjakauppa.tehtC24.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Book> books;
    private String name;

    public Category(String name) {

        this.id = null;
        this.name = name;
    }

    public Category() {
        this.id = null;
        this.name = null;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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
/*
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", books=" + books +
                ", name=" + name +
                ", books=" + books +
                '}';
    }*/
}
