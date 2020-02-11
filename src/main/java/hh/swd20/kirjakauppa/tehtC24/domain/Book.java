package hh.swd20.kirjakauppa.tehtC24.domain;

public class Book {

    private String title, author, year, ISBN;
    private double price;

    public Book (String title, String author, String year, String ISBN, double price) {

        this.title = title;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
        this.price = price;

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
