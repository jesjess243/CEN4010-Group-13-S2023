//Removing a book from a wishlist
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookRemover {
    // Connect to MySQL database
    private Connection connect() {
        //MySQL database credentials
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
// Removing books from a wishlist
    public void removeBookFromWishlist(int bookId, int wishlistId) {
        String sql = "DELETE FROM wishlist_books WHERE book_id = ? AND wishlist_id = ?";

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