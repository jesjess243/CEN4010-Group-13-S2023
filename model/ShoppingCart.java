package ShoppingCart.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ShoppingCart {
    @Entity
    public class ShoppingCart {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        private User user;

        @ManyToMany
        private List<Book> books = new ArrayList<>();

        // getters and setters
        // constructors
        // other methods
    }

}
