package mate.academy.bookstore.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;
import lombok.Data;

@Data
public class ShoppingCartRequestDto {
    @NotEmpty
    @Valid
    private Set<CartItemRequestDto> cartItems;
}
