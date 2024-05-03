package mate.academy.bookstore.handler;

import java.util.List;
import org.springframework.http.HttpStatus;

public class ErrorResponseData extends ResponseData {
    public ErrorResponseData(HttpStatus status, Object data, List<ErrorMessage> errors) {
        super(status, data, errors);
    }
}
