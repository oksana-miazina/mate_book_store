package mate.academy.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderCreateRequestDto {
    @NotBlank
    private String shippingAddress;
}
