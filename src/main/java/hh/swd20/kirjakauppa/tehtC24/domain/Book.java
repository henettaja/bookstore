package hh.swd20.kirjakauppa.tehtC24.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    private String title, author, year, ISBN;
    private double price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Book (String title, String author, String year, String ISBN, double price) {

        this.title = title;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
        this.price = price;
        this.id = null;

    }

    public Book () {
        this.title = null;
        this.author = null;
        this.year = null;
        this.ISBN = null;
        this.price = 0;
        this.id = null;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
