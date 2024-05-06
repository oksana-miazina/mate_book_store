package mate.academy.bookstore.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import mate.academy.bookstore.dto.BookDto;
import mate.academy.bookstore.dto.BookRequestDto;
import mate.academy.bookstore.exception.EntityNotFoundException;
import mate.academy.bookstore.mapper.BookMapper;
import mate.academy.bookstore.model.Book;
import mate.academy.bookstore.repository.BookRepository;
import mate.academy.bookstore.service.BookService;
import mate.academy.bookstore.service.LocaleService;
import org.springframework.dao.DataIntegrityViolationException;
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
                    throw new DataIntegrityViolationException(
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
    public BookDto updateById(Long id, BookRequestDto bookRequestDto) {
        getBookByIdOrThrowException(id);
        Book book = bookMapper.toModel(bookRequestDto);
        book.setId(id);
        return bookMapper.toDto(bookRepository.save(book));
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
