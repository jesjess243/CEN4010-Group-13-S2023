package ShoppingCart.service;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, BookRepository bookRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.bookRepository = bookRepository;
    }

    public ShoppingCart findByUserId(Long userId) {
        return shoppingCartRepository.findByUserId(userId).orElseThrow(() -> new EntityNotFoundException("Shopping cart not found for user with id: " + userId));
    }

    public BigDecimal calculateSubtotal(Long userId) {
        ShoppingCart shoppingCart = findByUserId(userId);
        return shoppingCart.getBooks().stream().map(Book::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addBookToCart(Long userId, Long bookId) {
        ShoppingCart shoppingCart = findByUserId(userId);
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + bookId));
        shoppingCart.getBooks().add(book);
        shoppingCartRepository.save(shoppingCart);
    }

    public List<Book> findBooksInCart(Long userId) {
        ShoppingCart shoppingCart = findByUserId(userId);
        return shoppingCart.getBooks();
    }

    public void removeBookFromCart(Long userId, Long bookId) {
        ShoppingCart shoppingCart = findByUserId(userId);
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + bookId));
        shoppingCart.getBooks().remove(book);
        shoppingCartRepository.save(shoppingCart);
    }
}

}
