package mate.academy.bookstore.service;

import java.util.List;
import mate.academy.bookstore.dto.BookDto;
import mate.academy.bookstore.dto.BookRequestDto;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(BookRequestDto bookDto);

    List<BookDto> findAll(Pageable pageable);

    BookDto getById(Long id);

    BookDto updateById(Long id, BookRequestDto bookRequestDto);

    void deleteById(Long id);
}
