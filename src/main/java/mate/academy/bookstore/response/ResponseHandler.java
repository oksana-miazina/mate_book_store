package mate.academy.bookstore.response;

import java.util.List;
import org.springframework.http.HttpStatus;

public class ResponseHandler {
    public static ErrorResponse getErrorResponse(
            String message, HttpStatus status) {
        return new ErrorResponse(List.of(new ErrorResponse.Message(null, message)), status);
    }

    public static ErrorResponse getErrorResponse(
            List<ErrorResponse.Message> messages, HttpStatus status) {
        return new ErrorResponse(messages, status);
    }

    public static <T> SuccessResponse<T> getSuccessResponse(T data) {
        return getSuccessResponse(data, HttpStatus.OK);
    }

    public static <T> SuccessResponse<T> getSuccessResponse(
            T data, HttpStatus status) {
        return new SuccessResponse<>(data, status);
    }
}
