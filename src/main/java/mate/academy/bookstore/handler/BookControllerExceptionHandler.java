package mate.academy.bookstore.handler;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import mate.academy.bookstore.exception.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BookControllerExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        return getResponseEntity(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            Map.Entry<String, String> errorMessage = getErrorMessage(error);
            errors.put(errorMessage.getKey(), errorMessage.getValue());
        });

        return getResponseEntity(HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity<Object> handleDataIntegrityViolationException(
            DataIntegrityViolationException ex) {
        return getResponseEntity(HttpStatus.CONFLICT, ex.getMessage());
    }

    private Map.Entry<String, String> getErrorMessage(ObjectError e) {
        if (e instanceof FieldError fieldError) {
            String field = fieldError.getField();
            String message = e.getDefaultMessage();
            return Map.entry(field, message);
        }
        return Map.entry("", e.getDefaultMessage());
    }

    private ResponseEntity<Object> getResponseEntity(HttpStatus status, Object errors) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("success", status.is2xxSuccessful());
        body.put("errors", errors);
        return new ResponseEntity<>(body, status);
    }
}

