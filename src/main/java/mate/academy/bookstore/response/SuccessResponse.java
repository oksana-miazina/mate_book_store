package mate.academy.bookstore.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SuccessResponse<T> extends GeneralResponse {
    private T data;

    public SuccessResponse(T data, HttpStatus status) {
        super(status);
        this.data = data;
    }
}
