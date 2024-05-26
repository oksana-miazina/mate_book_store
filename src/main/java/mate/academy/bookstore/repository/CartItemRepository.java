package mate.academy.bookstore.repository;

import mate.academy.bookstore.model.CartItem;
import mate.academy.bookstore.model.CartItemKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemKey> {
}
