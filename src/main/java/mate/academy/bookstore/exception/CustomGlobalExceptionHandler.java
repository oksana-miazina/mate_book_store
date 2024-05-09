package mate.academy.bookstore.exception;

import java.util.List;
import mate.academy.bookstore.response.ErrorResponse;
import mate.academy.bookstore.response.ResponseHandler;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception ex) {
        return ResponseHandler.getErrorResponse(
                ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse handleEntityNotFoundException(
            EntityNotFoundException ex) {
        return ResponseHandler.getErrorResponse(
                ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<ErrorResponse.Message> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(this::getErrorMessage)
                .toList();
        return ResponseHandler.getErrorResponse(
                errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PropertyReferenceException.class)
    public ErrorResponse handlePropertyReferenceException(
            PropertyReferenceException ex) {
        return ResponseHandler.getErrorResponse(
                ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            RegistrationException.class,
            DataIntegrityViolationException.class,
            EntityAlreadyExistsException.class
    })
    public ErrorResponse handleDataIntegrityViolationException(
            Exception ex) {
        return ResponseHandler.getErrorResponse(
                ex.getMessage(), HttpStatus.CONFLICT);
    }

    private ErrorResponse.Message getErrorMessage(ObjectError e) {
        String field = null;
        if (e instanceof FieldError fieldError) {
            field = fieldError.getField();
        }
        return new ErrorResponse.Message(field, e.getDefaultMessage());
    }
}
