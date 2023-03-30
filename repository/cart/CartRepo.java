package ShoppingCart.repository.cart;

public interface CartRepo {
    @Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserId(Long userId);
}

}
