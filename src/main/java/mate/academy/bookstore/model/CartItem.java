package mate.academy.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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

    @Column(nullable = false)
    private int quantity;
}
