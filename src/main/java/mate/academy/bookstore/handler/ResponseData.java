package mate.academy.bookstore.handler;

import java.util.List;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ResponseData {
    private boolean success;

    private int status;
    private Object data;
    private List<ErrorMessage> errors;

    public ResponseData(HttpStatus status, Object data, List<ErrorMessage> errors) {
        this.data = data;
        this.errors = errors;
        this.status = status.value();
        this.success = status.is2xxSuccessful();
    }
}

