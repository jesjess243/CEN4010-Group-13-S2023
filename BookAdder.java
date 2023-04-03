//Adding a book to a wishlist
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookAdder {
    // Connect to MySQL database
    private Connection connect() {
        // MySQL database credentials
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String username = "root";
        String password = "5284He!";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
// Adding books into a certain wishlist by taking in both book and wishlist IDs
    public void addBookToWishlist(int bookId, int wishlistId) {
        String sql = "INSERT INTO wishlist_books(book_id, wishlist_id) VALUES (?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            pstmt.setInt(2, wishlistId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
