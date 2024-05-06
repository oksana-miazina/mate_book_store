package mate.academy.bookstore.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class GeneralResponse {
    private final boolean success;
    private final int status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Schema(type = "string", example = "06-05-2024 06:48:10")
    private final Date timestamp;

    public GeneralResponse(HttpStatus status) {
        this.timestamp = new Date();
        this.status = status.value();
        this.success = status.is2xxSuccessful();
    }
}
