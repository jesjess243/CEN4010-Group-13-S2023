import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRemoverController {

    // Inject BookRemover instance
    private final BookRemover bookRemover;

    public BookRemoverController(BookRemover bookRemover) {
        this.bookRemover = bookRemover;
    }

    // HTTP DELETE request to remove a book from a wishlist
    @DeleteMapping("/wishlist/{wishlistId}/books/{bookId}")
    public void removeBookFromWishlist(@PathVariable int wishlistId, @PathVariable int bookId) {
        bookRemover.removeBookFromWishlist(bookId, wishlistId);
    }

}
