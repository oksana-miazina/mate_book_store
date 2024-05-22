package mate.academy.bookstore.service.impl;

import java.util.List;
import java.util.Objects;
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
        Category category = getModelById(id);
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto save(CategoryRequestDto categoryDto) {
        if (categoryRepository.existsByName(categoryDto.getName())) {
            throw getAlreadyExistsException();
        }
        Category category = categoryMapper.toModel(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public CategoryDto update(Long id, CategoryRequestDto categoryDto) {
        Category categoryFromDB = getModelById(id);
        String newName = categoryDto.getName();

        if (!Objects.equals(categoryFromDB.getName(), newName)
                && categoryRepository.existsByName(newName)) {
            throw getAlreadyExistsException();
        }

        Category category = categoryMapper.toModel(categoryDto);
        category.setId(id);
        return categoryMapper.toDto(
                categoryRepository.save(category)
        );
    }

    @Override
    public void deleteById(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw getNotFoundException(id);
        }
        categoryRepository.deleteById(id);
    }

    private Category getModelById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> getNotFoundException(id));
    }

    private EntityAlreadyExistsException getAlreadyExistsException() {
        return new EntityAlreadyExistsException(
                localeService.getMessage("exception.exists.category")
        );
    }

    private EntityNotFoundException getNotFoundException(Long id) {
        return new EntityNotFoundException(
                localeService.getMessage("exception.notfound.category") + id
        );
    }
}
