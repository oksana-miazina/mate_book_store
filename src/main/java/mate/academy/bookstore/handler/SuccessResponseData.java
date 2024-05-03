package mate.academy.bookstore.handler;

import java.util.List;
import org.springframework.http.HttpStatus;

public class SuccessResponseData extends ResponseData {
    public SuccessResponseData(HttpStatus status, Object data, List<ErrorMessage> errors) {
        super(status, data, errors);
    }
}
