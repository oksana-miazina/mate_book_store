package mate.academy.bookstore.repository;

import java.util.List;
import java.util.Optional;
import mate.academy.bookstore.model.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @EntityGraph(attributePaths = {"orderItems"})
    List<Order> findByUser_Id(Long id);

    @EntityGraph(attributePaths = {"orderItems"})
    Optional<Order> findByIdAndUser_Id(Long orderId, Long userId);
}
