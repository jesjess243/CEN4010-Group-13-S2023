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
    repo repoTest;

    @Autowired
    bookService bookServ = new bookService();
    

    @GetMapping("/books-list-genre/{genre}")
    public List<Book> findByGenreContaining(@PathVariable("genre") String genre) {
        return repoTest.findByGenre(genre);
    }


   @GetMapping("/books-list-rating/{minimumrating}")
    public List<Book> findbyrating(@PathVariable("minimumrating") double minimumrating) {
       return repoTest.findByratingGreaterThanEqual(minimumrating);
    }

    @GetMapping("/books-list-topsellers")
    public List<Book> topSellers() {
       return repoTest.findTop10BySalesGreaterThanOrderBySalesDesc(0);
    }


    @PatchMapping("/books-update/{publisher}/{percent}")
    public List<Book> updatePublisher(@PathVariable("publisher") String publisher, @PathVariable("percent") double discountPercent) {
        return bookServ.updatePublisherDiscount(publisher, discountPercent);
    }

}
