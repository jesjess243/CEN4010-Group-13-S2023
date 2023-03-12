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
    private String genre;
    @Column
    private Integer bookid;
    private String bookname;
    private String author;



    public Book(Integer bookid, String bookname, String author, String publisher, Double price, String genre) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.genre = genre;
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
    /* Debugging testing set discount function
       public void setDiscount(double discountPercent) {
       this.price *= 1 - (discountPercent / 100);
         }
   */
    public String getGenre() {
        return genre;
    }
    public void setGenre() {
        this.genre = genre;
    }
    public Book() {
    }

}
