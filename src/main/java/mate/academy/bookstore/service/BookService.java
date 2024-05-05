package mate.academy.bookstore.service;

import java.util.List;
import mate.academy.bookstore.dto.BookDto;
import mate.academy.bookstore.dto.BookRequestDto;

public interface BookService {
    BookDto save(BookRequestDto bookDto);

    List<BookDto> findAll();

    BookDto getById(Long id);

    BookDto updateById(Long id, BookRequestDto bookRequestDto);

    void deleteById(Long id);

    int tes();
}
