//Listing the books in a wishlist
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BookLister {
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
// Listing the books inside a certain wishlist
    public List<Book> listBooksInWishlist(int wishlistId) {
        String sql = "SELECT b.* FROM books b JOIN wishlist_books wb ON b.book_id = wb.book_id WHERE wb.wishlist_id = ?";

        List<Book> books = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, wishlistId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int bookId = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                Book book = new Book(bookId, title, author, price);
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }
}
