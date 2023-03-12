package BookRetrieve.repository;
import BookRetrieve.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface repo extends JpaRepository<Book, Integer> {
    List<Book> findByGenre(@Param("genre") String genre);
    List<Book> findBypublisher(@Param("publisher") String publisher);

    List<Book> findByratingGreaterThanEqual(@Param("rating") double rating);

    List<Book> findTop10BySalesGreaterThanOrderBySalesDesc(@Param("sales") Integer sales);
}
