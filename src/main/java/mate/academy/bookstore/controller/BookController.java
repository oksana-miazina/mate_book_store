package mate.academy.bookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.bookstore.dto.BookDto;
import mate.academy.bookstore.dto.BookRequestDto;
import mate.academy.bookstore.response.ErrorResponse;
import mate.academy.bookstore.response.ResponseHandler;
import mate.academy.bookstore.response.SuccessResponse;
import mate.academy.bookstore.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Management", description = "Endpoints for managing books")
@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    @Operation(summary = "Get all books", description = "Get all books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", useReturnTypeSchema = true)
    })
    public SuccessResponse<List<BookDto>> getAll(Pageable pageable) {
        return ResponseHandler.getSuccessResponse(
                bookService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by id", description = "Get book by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "404", content =
                    { @Content(schema = @Schema(implementation = ErrorResponse.class)) }),
    })
    public SuccessResponse<BookDto> getBookById(@PathVariable Long id) {
        return ResponseHandler.getSuccessResponse(
                bookService.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new book", description = "Create a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "409", description = "Book with such ISBN already exists",
                    content = { @Content(schema = @Schema(implementation = ErrorResponse.class)) }),
    })
    public SuccessResponse<BookDto> createBook(
            @Valid @RequestBody BookRequestDto bookDto) {
        return ResponseHandler.getSuccessResponse(
                bookService.save(bookDto),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing book", description = "Update an existing book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "409",
                    description = "Book with such ISBN already exists "
                            + "(possible if new ISBN differs from old one)",
                    content = { @Content(schema = @Schema(implementation = ErrorResponse.class)) }),
    })
    public SuccessResponse<BookDto> updateBookById(@PathVariable Long id,
                                                   @Valid @RequestBody BookRequestDto bookDto) {
        return ResponseHandler.getSuccessResponse(
                bookService.updateById(id, bookDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete book by id", description = "Delete book by id")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "404", content =
                    { @Content(schema = @Schema(implementation = ErrorResponse.class)) }),
    })
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
