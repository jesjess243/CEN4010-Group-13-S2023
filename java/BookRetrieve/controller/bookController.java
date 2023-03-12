package BookRetrieve.controller;

import BookRetrieve.model.Book;
import BookRetrieve.repository.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class bookController {
    @Autowired
    repo repoTest;

    @PostMapping("/bookss")
    public Book save(@RequestBody Book book) {
        return repoTest.save(book);
    }

    @GetMapping("/books-list")
    public List<Book> getAllBooks() {
       return repoTest.findAll();
    }

    @GetMapping("/books-list-genre/{genre}")
    public List<Book> findByGenreContaining(@PathVariable("genre") String genre) {
        return repoTest.findByGenre(genre);
    }
}
