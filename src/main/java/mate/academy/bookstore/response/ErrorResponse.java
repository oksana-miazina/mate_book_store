package mate.academy.bookstore.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse extends GeneralResponse {
    private final List<Message> errors;

    public record Message(String field, String message) {
    }

    public ErrorResponse(List<Message> errors, HttpStatus status) {
        super(status);
        this.errors = errors;
    }

    @Schema(example = "false")
    public boolean getSuccess() {
        return isSuccess();
    }
}
