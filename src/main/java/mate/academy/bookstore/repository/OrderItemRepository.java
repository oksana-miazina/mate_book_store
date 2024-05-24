package mate.academy.bookstore.repository;

import java.util.List;
import java.util.Optional;
import mate.academy.bookstore.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrder_IdAndOrder_User_Id(Long orderId, Long userId);

    Optional<OrderItem> findByIdAndOrder_IdAndOrder_User_Id(Long itemId, Long orderId, Long userId);
}
