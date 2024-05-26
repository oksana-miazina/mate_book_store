package mate.academy.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CartItemKey implements Serializable {
    @Column(name = "shopping_cart_id", nullable = false)
    private Long shoppingCartId;

    @Column(name = "book_id", nullable = false)
    private Long bookId;
}
