package mate.academy.bookstore.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.bookstore.dto.BookDtoWithoutCategoryIds;
import mate.academy.bookstore.dto.CategoryDto;
import mate.academy.bookstore.dto.CategoryRequestDto;
import mate.academy.bookstore.response.ResponseHandler;
import mate.academy.bookstore.response.SuccessResponse;
import mate.academy.bookstore.service.BookService;
import mate.academy.bookstore.service.CategoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final BookService bookService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessResponse<CategoryDto> createCategory(
            @Valid @RequestBody CategoryRequestDto categoryDto) {
        return ResponseHandler.getSuccessResponse(
                categoryService.save(categoryDto),
                HttpStatus.CREATED);
    }

    @GetMapping
    public SuccessResponse<List<CategoryDto>> getAll(Pageable pageable) {
        return ResponseHandler.getSuccessResponse(
                categoryService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public SuccessResponse<CategoryDto> getCategoryById(@PathVariable Long id) {
        return ResponseHandler.getSuccessResponse(
                categoryService.getById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public SuccessResponse<CategoryDto> updateCategory(
            @PathVariable Long id, @Valid @RequestBody CategoryRequestDto categoryDto) {
        return ResponseHandler.getSuccessResponse(
                categoryService.update(id, categoryDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

    @GetMapping("/{id}/books")
    public SuccessResponse<List<BookDtoWithoutCategoryIds>> getBooksByCategoryId(
            @PathVariable Long id, Pageable pageable) {
        return ResponseHandler.getSuccessResponse(
                bookService.getBooksByCategoryId(id, pageable)
        );
    }
}
