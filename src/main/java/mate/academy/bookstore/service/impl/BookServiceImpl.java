package mate.academy.bookstore.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.bookstore.dto.BookDto;
import mate.academy.bookstore.dto.BookDtoWithoutCategoryIds;
import mate.academy.bookstore.dto.BookRequestDto;
import mate.academy.bookstore.exception.EntityAlreadyExistsException;
import mate.academy.bookstore.exception.EntityNotFoundException;
import mate.academy.bookstore.mapper.BookMapper;
import mate.academy.bookstore.model.Book;
import mate.academy.bookstore.model.Category;
import mate.academy.bookstore.repository.BookRepository;
import mate.academy.bookstore.repository.CategoryRepository;
import mate.academy.bookstore.service.BookService;
import mate.academy.bookstore.service.LocaleService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final BookMapper bookMapper;
    private final LocaleService localeService;

    @Override
    public BookDto save(BookRequestDto bookDto) {
        bookRepository.findByIsbn(bookDto.getIsbn())
                .ifPresent(s -> {
                    throw new EntityAlreadyExistsException(
                            localeService.getMessage("exception.exists.book")
                    );
                });

        Book book = bookMapper.toModel(bookDto);
        validateBookCategoriesExistence(book.getCategories());
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto getById(Long id) {
        Book book = getBookByIdOrThrowException(id);
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDtoWithoutCategoryIds> getBooksByCategoryId(Long id, Pageable pageable) {
        return bookRepository.findAllByCategoriesId(id, pageable).stream()
                .map(bookMapper::toDtoWithoutCategories)
                .toList();
    }

    @Override
    public BookDto updateById(Long id, BookRequestDto bookDto) {
        Book book = getBookByIdOrThrowException(id);

        if (!book.getIsbn().equals(bookDto.getIsbn())) {
            Optional<Book> bookByIsbn = bookRepository.findByIsbn(bookDto.getIsbn());
            if (bookByIsbn.isPresent() && !Objects.equals(bookByIsbn.get().getId(), book.getId())) {
                throw new EntityAlreadyExistsException(
                        localeService.getMessage("exception.exists.book")
                );
            }
        }

        Book bookUpdated = bookMapper.toModel(bookDto);
        validateBookCategoriesExistence(bookUpdated.getCategories());
        bookUpdated.setId(id);
        return bookMapper.toDto(bookRepository.save(bookUpdated));
    }

    @Override
    public void deleteById(Long id) {
        getBookByIdOrThrowException(id);
        bookRepository.deleteById(id);
    }

    private Book getBookByIdOrThrowException(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        localeService.getMessage("exception.notfound.book") + id
                ));
    }

    private void validateBookCategoriesExistence(Set<Category> categories) {
        List<Long> categoriesIds = categories.stream()
                .map(Category::getId)
                .toList();
        Set<Long> existingCategories = categoryRepository.findByIdIn(categoriesIds)
                .stream()
                .map(Category::getId)
                .collect(Collectors.toSet());

        if (existingCategories.size() != categories.size()) {
            Set<Long> notFoundCategories = new HashSet<>(categoriesIds);
            notFoundCategories.removeAll(existingCategories);
            throw new EntityNotFoundException(
                    localeService.getMessage("exception.notfound.categories") + notFoundCategories
            );
        }
    }
}
