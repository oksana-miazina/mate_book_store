package mate.academy.bookstore.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mate.academy.bookstore.dto.CategoryDto;
import mate.academy.bookstore.dto.CategoryRequestDto;
import mate.academy.bookstore.exception.EntityAlreadyExistsException;
import mate.academy.bookstore.exception.EntityNotFoundException;
import mate.academy.bookstore.mapper.CategoryMapper;
import mate.academy.bookstore.model.Category;
import mate.academy.bookstore.repository.CategoryRepository;
import mate.academy.bookstore.service.CategoryService;
import mate.academy.bookstore.service.LocaleService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final LocaleService localeService;

    @Override
    public List<CategoryDto> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    @Override
    public CategoryDto getById(Long id) {
        Category category = getCategoryByIdOrThrowException(id);
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto save(CategoryRequestDto categoryDto) {
        categoryRepository.findByName(categoryDto.getName())
                .ifPresent(s -> {
                    throw new EntityAlreadyExistsException(
                            localeService.getMessage("exception.exists.category")
                    );
                });
        Category category = categoryMapper.toModel(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public CategoryDto update(Long id, CategoryRequestDto categoryDto) {
        Category category = getCategoryByIdOrThrowException(id);

        if (!category.getName().equals(categoryDto.getName())) {
            Optional<Category> categoryByIsbn =
                    categoryRepository.findByName(categoryDto.getName());
            if (categoryByIsbn.isPresent()
                    && !Objects.equals(categoryByIsbn.get().getId(), category.getId())) {
                throw new EntityAlreadyExistsException(
                        localeService.getMessage("exception.exists.category")
                );
            }
        }

        Category categoryUpdated = categoryMapper.toModel(categoryDto);
        categoryUpdated.setId(id);
        return categoryMapper.toDto(categoryRepository.save(categoryUpdated));
    }

    @Override
    public void deleteById(Long id) {
        getCategoryByIdOrThrowException(id);
        categoryRepository.deleteById(id);
    }

    private Category getCategoryByIdOrThrowException(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        localeService.getMessage("exception.notfound.category") + id
                ));
    }
}
