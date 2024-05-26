package mate.academy.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CartItem {
    @EmbeddedId
    private CartItemKey id;

    @MapsId("shoppingCartId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "shopping_cart_id", nullable = false)
    private ShoppingCart shoppingCart;

    @MapsId("bookId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    @EqualsAndHashCode.Exclude
    private int quantity;
}
