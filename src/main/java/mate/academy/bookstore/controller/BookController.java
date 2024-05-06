package mate.academy.bookstore.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.bookstore.dto.BookDto;
import mate.academy.bookstore.dto.BookRequestDto;
import mate.academy.bookstore.response.ResponseHandler;
import mate.academy.bookstore.response.SuccessResponse;
import mate.academy.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<SuccessResponse<List<BookDto>>> getAll() {
        return ResponseHandler.getSuccessResponse(
                bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<BookDto>> getBookById(@PathVariable Long id) {
        return ResponseHandler.getSuccessResponse(
                bookService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SuccessResponse<BookDto>> createBook(
            @Valid @RequestBody BookRequestDto bookDto) {
        return ResponseHandler.getSuccessResponse(
                bookService.save(bookDto),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<BookDto>> updateBookById(@PathVariable Long id,
                                  @RequestBody BookRequestDto bookRequestDto) {
        return ResponseHandler.getSuccessResponse(
                bookService.updateById(id, bookRequestDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateBookById(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
