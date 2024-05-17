package mate.academy.bookstore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import mate.academy.bookstore.validator.FieldMatch;

@Data
@FieldMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "{validation.password.notmatch}"
)
public class UserRegistrationRequestDto {
    @NotBlank(message = "{validation.email.notempty}")
    @Email(message = "{validation.email.valid}")
    @Size(min = 8, max = 150, message = "{validation.email.size}")
    private String email;
    @NotBlank(message = "{validation.password.notempty}")
    @Size(min = 8, max = 150, message = "{validation.password.size}")
    private String password;
    @NotBlank(message = "{validation.password.notempty}")
    @Size(min = 8, max = 150, message = "{validation.password.size}")
    private String repeatPassword;
    @NotBlank(message = "{validation.field.notempty}")
    private String firstName;
    @NotBlank(message = "{validation.field.notempty}")
    private String lastName;
    private String shippingAddress;
}
