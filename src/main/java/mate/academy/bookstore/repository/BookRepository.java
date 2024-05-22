package mate.academy.bookstore.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import mate.academy.bookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @EntityGraph(attributePaths = {"categories"})
    Optional<Book> findById(Long id);

    Optional<Book> findByIsbn(String isbn);

    List<Book> findAllByCategoriesId(Long categoryId, Pageable pageable);

    @Query("FROM Book b JOIN FETCH b.categories c")
    Page<Book> findAll(Pageable pageable);

    Set<Book> findByIdIn(List<Long> ids);
}
