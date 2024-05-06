package mate.academy.bookstore.response;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<ErrorResponse> getErrorResponse(
            String message, HttpStatus status) {
        return new ResponseEntity<>(
                new ErrorResponse(List.of(new ErrorResponse.Message(null, message)), status),
                status);
    }

    public static ResponseEntity<ErrorResponse> getErrorResponse(
            List<ErrorResponse.Message> messages, HttpStatus status) {
        return new ResponseEntity<>(
                new ErrorResponse(messages, status),
                status);
    }

    public static <T> ResponseEntity<SuccessResponse<T>> getSuccessResponse(T data) {
        return getSuccessResponse(data, HttpStatus.OK);
    }

    public static <T> ResponseEntity<SuccessResponse<T>> getSuccessResponse(
            T data, HttpStatus status) {
        return new ResponseEntity<>(
                new SuccessResponse<>(data, status),
                status);
    }
}
