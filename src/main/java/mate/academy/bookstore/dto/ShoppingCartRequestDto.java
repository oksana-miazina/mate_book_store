package mate.academy.bookstore.dto;

import jakarta.validation.constraints.NotEmpty;
import java.util.Set;
import lombok.Data;

@Data
public class ShoppingCartRequestDto {
    @NotEmpty
    private Set<CartItemRequestDto> cartItems;
}
