package mate.academy.bookstore.repository;

import java.util.Optional;
import mate.academy.bookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
