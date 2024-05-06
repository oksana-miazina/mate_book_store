package mate.academy.bookstore.response;

import java.util.List;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse extends GeneralResponse {
    private List<Message> errors;

    public record Message(String field, String message) {
    }

    public ErrorResponse(List<Message> errors, HttpStatus status) {
        super(status);
        this.errors = errors;
    }
}