package mate.academy.bookstore.repository;

import java.util.List;
import java.util.Optional;
import mate.academy.bookstore.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);

    @Query("FROM Book b JOIN b.categories c WHERE c.id = :categoryId")
    List<Book> findAllByCategoryId(Long categoryId, Pageable pageable);
}
