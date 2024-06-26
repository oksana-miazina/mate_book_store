package mate.academy.bookstore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String author;
    @Schema(example = "ISBN-13: 978-0-596-52068-7")
    private String isbn;
    @Schema(example = "0.01")
    private BigDecimal price;
    private String description;
    private String coverImage;
    private List<Long> categoryIds;
}
