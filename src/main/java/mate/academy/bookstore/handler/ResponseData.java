package mate.academy.bookstore.handler;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ResponseData {
    @Schema(type = "boolean", example = "false")
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

