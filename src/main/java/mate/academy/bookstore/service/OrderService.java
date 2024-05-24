package mate.academy.bookstore.service;

import java.util.List;
import mate.academy.bookstore.dto.OrderCreateRequestDto;
import mate.academy.bookstore.dto.OrderDto;
import mate.academy.bookstore.dto.OrderItemDto;
import mate.academy.bookstore.dto.OrderUpdateRequestDto;
import mate.academy.bookstore.model.User;

public interface OrderService {
    OrderDto getOrderById(Long orderId, User user);

    OrderItemDto getOrderItemById(Long itemId, Long orderId, User user);

    List<OrderItemDto> getOrderItemsByOrderId(Long orderId, User user);

    List<OrderDto> findAll(User user);

    OrderDto create(OrderCreateRequestDto dto, User user);

    OrderDto updateById(Long id, OrderUpdateRequestDto dto);
}
