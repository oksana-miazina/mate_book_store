package mate.academy.bookstore.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @NotBlank(message = "ISBN is required")
    @Pattern(regexp = "^\\d{13}$", message = "The ISBN must contain exactly 13 digits")
    private String isbn;

    @DecimalMin(value = "0.01", message = "The price must be greater than 0")
    private BigDecimal price;

    private String description;
    private String coverImage;
}
