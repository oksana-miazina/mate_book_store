package mate.academy.bookstore.repository;

import mate.academy.bookstore.model.CartItem;
import mate.academy.bookstore.model.CartItemKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemKey> {
    Set<CartItem> getById_Book_IdIn(List<Long> ids);
}
