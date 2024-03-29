package BookRetrieve.controller;

import BookRetrieve.model.Book;
import BookRetrieve.repository.repo;
import BookRetrieve.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class bookController {
    @Autowired
    repo repository;

    @Autowired
    bookService bookService = new bookService();

    // Getmapping which returns all books matching the input genre
    @GetMapping("/books-list-genre/{genre}")
    public List<Book> findByGenreContaining(@PathVariable("genre") String genre) {
        return repository.findByGenre(genre);
    }

    // Getmapping which returns all books in the database with a rating equal to or GREATER than that entered
   @GetMapping("/books-list-rating/{minimumrating}")
    public List<Book> findbyrating(@PathVariable("minimumrating") double minimumrating) {
       return repository.findByratingGreaterThanEqual(minimumrating);
    }
    // Getmapping which returns the top 10 sellers, in decesending order
    @GetMapping("/books-list-topsellers")
    public List<Book> topSellers() {
        return repository.findTop10BySalesGreaterThanOrderBySalesDesc(0);
    }
    // Patchmap which is used for discounting all books under a publisher by the input percentage
    @PatchMapping("/books-update")
    public List<Book> updatePublisher(@RequestBody Book book) {
        String publisher = book.getPublisher();
        Double discountPercent = book.getDiscount();
        System.out.println("publisher, discountPercent");
        return bookService.updatePublisherDiscount(publisher, discountPercent);
    }

}
