package mate.academy.bookstore.service;

import java.util.List;
import mate.academy.bookstore.dto.CategoryDto;
import mate.academy.bookstore.dto.CategoryRequestDto;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    List<CategoryDto> findAll(Pageable pageable);

    CategoryDto getById(Long id);

    CategoryDto save(CategoryRequestDto categoryDto);

    CategoryDto update(Long id, CategoryRequestDto categoryDto);

    void deleteById(Long id);
}
