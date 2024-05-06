package mate.academy.bookstore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class BookRequestDto {
    private static final String ISBN_PATTERN =
            "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})"
                + "[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)"
                + "(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
    private static final String PRICE_MIN = "0.01";

    @NotBlank(message = "{validation.title.notempty}")
    private String title;

    @NotBlank(message = "{validation.author.notempty}")
    private String author;

    @NotBlank(message = "{validation.isbn.notempty}")
    @Pattern(regexp = ISBN_PATTERN, message = "{validation.isbn.valid}")
    @Schema(type = "string", example = "ISBN-13: 978-0-596-52068-7")
    private String isbn;

    @DecimalMin(value = PRICE_MIN, message = "{validation.price.valid}")
    private BigDecimal price;

    private String description;
    private String coverImage;
}
