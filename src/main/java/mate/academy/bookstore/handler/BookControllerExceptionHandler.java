package mate.academy.bookstore.handler;

import java.util.List;
import mate.academy.bookstore.exception.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookControllerExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseData handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseData(
                HttpStatus.NOT_FOUND,
                null,
                List.of(new ErrorMessage("", ex.getMessage()))
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErrorMessage> errors = ex.getBindingResult().getAllErrors().stream()
                .map(this::getErrorMessage)
                .toList();
        return new ResponseData(HttpStatus.BAD_REQUEST, null, errors);
    }

    @ExceptionHandler(PropertyReferenceException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseData handlePropertyReferenceException(PropertyReferenceException ex) {
        return new ResponseData(
                HttpStatus.BAD_REQUEST,
                null,
                List.of(new ErrorMessage("", ex.getMessage()))
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseData handleDataIntegrityViolationException(
            DataIntegrityViolationException ex) {
        return new ResponseData(
                HttpStatus.CONFLICT,
                null,
                List.of(new ErrorMessage("", ex.getMessage()))
        );
    }

    private ErrorMessage getErrorMessage(ObjectError e) {
        String field = "";
        if (e instanceof FieldError fieldError) {
            field = fieldError.getField();
        }
        return new ErrorMessage(field, e.getDefaultMessage());
    }
}
