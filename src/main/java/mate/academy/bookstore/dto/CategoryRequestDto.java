package mate.academy.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequestDto {
    @NotBlank(message = "{validation.field.notempty}")
    private String name;
    private String description;
}
