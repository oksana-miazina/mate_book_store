package mate.academy.bookstore.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import mate.academy.bookstore.dto.BookDto;
import mate.academy.bookstore.dto.BookDtoWithoutCategoryIds;
import mate.academy.bookstore.dto.BookRequestDto;
import mate.academy.bookstore.exception.EntityAlreadyExistsException;
import mate.academy.bookstore.exception.EntityNotFoundException;
import mate.academy.bookstore.mapper.BookMapper;
import mate.academy.bookstore.model.Book;
import mate.academy.bookstore.repository.BookRepository;
import mate.academy.bookstore.service.BookService;
import mate.academy.bookstore.service.LocaleService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
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
        return bookRepository.findAllByCategoryId(id, pageable).stream()
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
}
