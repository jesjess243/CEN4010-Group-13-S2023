//Main class
public class Main {

    public static void main(String[] args) {
        // Create a new wishlist for user
        WishlistCreator wishlistCreator = new WishlistCreator();
        // EX: Create a new wishlist for user 1
        wishlistCreator.createWishlist("My Wishlist", 1);

        // Add book to wishlist
        BookAdder bookAdder = new BookAdder();
        // EX: Add book 123 to wishlist 1
        bookAdder.addBookToWishlist(123, 1);

        // Remove book from wishlist
        BookRemover bookRemover = new BookRemover();
        // EX:Remove book 456 from wishlist 1
        bookRemover.removeBookFromWishlist(456, 1);

        // List all books in wishlist
        BookLister bookLister = new BookLister();
        // EX: List all books in wishlist 1
        List<Book> books = bookLister.listBooksInWishlist(1);
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
    }

}