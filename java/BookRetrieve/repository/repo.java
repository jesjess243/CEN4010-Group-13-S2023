package BookRetrieve.repository;

import BookRetrieve.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface repo extends JpaRepository<Book, Integer> {
    List<Book> findByGenre(@Param("genre") String genre);
    List<Book> findBypublisher(@Param("publisher") String publisher);

}
