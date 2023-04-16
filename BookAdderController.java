import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookAdderController extends HttpServlet {

    private BookAdder bookAdder;

    public void init() throws ServletException {
        // Create an instance of BookAdder to use for handling requests
        bookAdder = new BookAdder();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Extract bookId and wishlistId from request body
        String requestBody = request.getReader().lines().reduce("", (s1, s2) -> s1 + s2);
        int bookId = Integer.parseInt(requestBody.split(":")[1].split(",")[0]);
        int wishlistId = Integer.parseInt(requestBody.split(":")[2].split("}")[0]);

        // Call addBookToWishlist method to add book to wishlist
        bookAdder.addBookToWishlist(bookId, wishlistId);

        // Set response content type and write response message
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Book added to wishlist successfully</h2>");
        out.println("</body></html>");
    }
}
