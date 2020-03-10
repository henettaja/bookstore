package hh.swd20.kirjakauppa.tehtC24.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Book {

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private Category category;

    private String title, author, year, ISBN;
    private double price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Book (String title, String author, Category category, String year, String ISBN, double price) {

        this.title = title;
        this.author = author;
        this.category = category;
        this.year = year;
        this.ISBN = ISBN;
        this.price = price;
        this.id = null;

    }

    public Book () {
        this.title = null;
        this.author = null;
        this.category = null;
        this.year = null;
        this.ISBN = null;
        this.price = 0;
        this.id = null;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

   /* @Override
    public String toString() {
        return "Book{" +
                "category=" + category +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }*/
}
