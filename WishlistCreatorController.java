import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistCreatorController {

    // Inject WishlistCreator instance
    private final WishlistCreator wishlistCreator;

    public WishlistCreatorController(WishlistCreator wishlistCreator) {
        this.wishlistCreator = wishlistCreator;
    }

    // HTTP POST request to create a wishlist for a user
    @PostMapping("/wishlist")
    public void createWishlist(@RequestParam("wishlistName") String wishlistName,
                               @RequestParam("userId") int userId) {
        wishlistCreator.createWishlist(wishlistName, userId);
    }
}
