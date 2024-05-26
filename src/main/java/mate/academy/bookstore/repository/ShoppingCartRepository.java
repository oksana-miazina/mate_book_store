package mate.academy.bookstore.repository;

import mate.academy.bookstore.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query("FROM ShoppingCart sc "
            + "LEFT JOIN FETCH sc.cartItems ci "
            + "JOIN FETCH ci.book "
            + "WHERE sc.user.id = :userId")
    ShoppingCart getByUserId(Long userId);
}
