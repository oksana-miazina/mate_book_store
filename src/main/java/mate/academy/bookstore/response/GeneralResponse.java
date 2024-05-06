package mate.academy.bookstore.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class GeneralResponse {
    private final boolean success;
    private final int status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final Date timestamp;

    public GeneralResponse(HttpStatus status) {
        this.timestamp = new Date();
        this.status = status.value();
        this.success = status.is2xxSuccessful();
    }
}
