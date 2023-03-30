package BookRetrieve.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String publisher;
    private Double price;
    private Double rating;
    private String genre;
    private Integer bookid;
    private Integer sales;
    private String bookname;
    private String author;

    public Book(Integer bookid, String bookname, String author, String publisher, Double price, String genre, Double rating, Integer sales) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.genre = genre;
        this.sales = sales;
        this.rating = rating;
    }
    // Calculates the price discounted by an input percent, and rounded.
    public void setDiscount(Double discount) {
        double new_price, discountPercent;
        new_price = this.price;
        discountPercent = 100 - discount;
        new_price = discountPercent * new_price;
        new_price = new_price / 100;
        new_price = Math.round(new_price * 100);
        new_price = new_price / 100;

        new_price = Math.round(new_price * 100);
        new_price /= 100;
        this.price = new_price;
    }
    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public Integer getbookid() {
        return bookid;
    }

    public void setbookID(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setbookName(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice() {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre() {
        this.genre = genre;
    }
    public Book() {
    }

}
