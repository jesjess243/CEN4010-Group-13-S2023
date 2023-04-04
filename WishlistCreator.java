// Creating a wishlist
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WishlistCreator {
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
// Creating different wishlists with userId input and wishlist name
    public void createWishlist(String wishlistName, int userId) {
        String sql = "INSERT INTO wishlists(wishlist_name, user_id) VALUES (?, ?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, wishlistName);
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
