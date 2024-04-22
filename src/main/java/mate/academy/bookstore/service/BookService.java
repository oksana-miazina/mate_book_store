package mate.academy.bookstore.service;

import java.util.List;
import mate.academy.bookstore.dto.BookDto;
import mate.academy.bookstore.dto.BookRequestDto;

public interface BookService {
    BookDto save(BookRequestDto bookDto);

    List<BookDto> findAll();

    BookDto getById(Long id);

    BookDto updateBookById(Long id, BookRequestDto bookRequestDto);
}
