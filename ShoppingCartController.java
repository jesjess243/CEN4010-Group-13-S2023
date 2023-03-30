package ShoppingCart.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EntityNotFoundException;
@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/{userId}/subtotal")
    public ResponseEntity<BigDecimal> calculateSubtotal(@PathVariable Long userId) {
        BigDecimal subtotal = shoppingCartService.calculateSubtotal(userId);
        return ResponseEntity.ok(subtotal);
    }

    @PostMapping("/{userId}/books")
    public ResponseEntity<Void> addBookToCart(@PathVariable Long userId, @RequestBody Long bookId) {
        shoppingCartService.addBookToCart(userId, bookId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/books")
    public ResponseEntity<List<Book>> findBooksInCart(@PathVariable Long userId) {
        List<Book> books = shoppingCartService.findBooksInCart(userId);
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/{userId}/books/{bookId}")
    public ResponseEntity<Void> removeBookFromCart(@PathVariable Long userId, @PathVariable Long bookId) {
        shoppingCartService.removeBookFromCart(userId, bookId);
        return ResponseEntity.ok().build();
    }
}

}
