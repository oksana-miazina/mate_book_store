package mate.academy.bookstore.service.impl;

import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mate.academy.bookstore.dto.OrderCreateRequestDto;
import mate.academy.bookstore.dto.OrderDto;
import mate.academy.bookstore.dto.OrderItemDto;
import mate.academy.bookstore.dto.OrderUpdateRequestDto;
import mate.academy.bookstore.exception.EntityNotFoundException;
import mate.academy.bookstore.mapper.OrderItemMapper;
import mate.academy.bookstore.mapper.OrderMapper;
import mate.academy.bookstore.model.Book;
import mate.academy.bookstore.model.CartItem;
import mate.academy.bookstore.model.Order;
import mate.academy.bookstore.model.OrderItem;
import mate.academy.bookstore.model.ShoppingCart;
import mate.academy.bookstore.model.User;
import mate.academy.bookstore.repository.OrderItemRepository;
import mate.academy.bookstore.repository.OrderRepository;
import mate.academy.bookstore.repository.ShoppingCartRepository;
import mate.academy.bookstore.service.LocaleService;
import mate.academy.bookstore.service.OrderService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final ShoppingCartRepository shoppingCartRepository;
    private final LocaleService localeService;

    @Override
    public OrderDto getOrderById(Long orderId, User user) {
        Order order = orderRepository.findByIdAndUserId(orderId, user.getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        localeService.getMessage("exception.notfound.order") + orderId
                ));
        return orderMapper.toDto(order);
    }

    @Override
    public OrderItemDto getOrderItemById(Long itemId, Long orderId, User user) {
        OrderItem orderItem = orderItemRepository
                .findByIdAndOrderIdAndOrderUserId(itemId, orderId, user.getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        localeService.getMessage("exception.notfound.orderitem") + itemId
                ));
        return orderItemMapper.toDto(orderItem);
    }

    @Override
    public List<OrderItemDto> getOrderItemsByOrderId(Long orderId, User user) {
        List<OrderItem> orderItems = orderItemRepository
                .findByOrderIdAndOrderUserId(orderId, user.getId());
        if (orderItems.isEmpty()) {
            throw new EntityNotFoundException(
                    localeService.getMessage("exception.notfound.orderitems") + orderId
            );
        }
        return orderItems.stream()
                .map(orderItemMapper::toDto)
                .toList();
    }

    @Override
    public List<OrderDto> findAll(User user) {
        return orderRepository.findByUserId(user.getId()).stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public OrderDto create(OrderCreateRequestDto dto, User user) {
        Order order = createOrder(dto, user);
        pickUpItemsIntoOrder(order);
        order.setTotal(calculateTotal(order));

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    @Override
    public OrderDto updateById(Long id, OrderUpdateRequestDto dto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        localeService.getMessage("exception.notfound.order") + id
                ));
        order.setStatus(Order.Status.valueOf(dto.getStatus()));
        Order updatedOrder = orderRepository.save(order);
        return orderMapper.toDto(updatedOrder);
    }

    private void pickUpItemsIntoOrder(Order order) {
        ShoppingCart shoppingCart = shoppingCartRepository.getByUserId(order.getUser().getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        localeService.getMessage(
                                "exception.notfound.shoppingcart") + order.getUser().getId()
                ));

        order.setOrderItems(shoppingCart.getCartItems().stream()
                .map(cartItem -> createOrderItemFrom(cartItem, order))
                .collect(Collectors.toSet()));
        shoppingCartRepository.delete(shoppingCart);
    }

    private OrderItem createOrderItemFrom(CartItem cartItem, Order order) {
        Book book = cartItem.getId().getBook();

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setBook(new Book(book.getId()));
        orderItem.setQuantity(cartItem.getQuantity());
        orderItem.setPrice(book.getPrice());
        return orderItem;
    }

    private Order createOrder(OrderCreateRequestDto dto, User user) {
        Order order = new Order();
        order.setShippingAddress(dto.getShippingAddress());
        order.setOrderDate(LocalDateTime.now());
        order.setUser(user);
        order.setStatus(Order.Status.NEW);
        return order;
    }

    private BigDecimal calculateTotal(Order order) {
        return order.getOrderItems().stream()
                .map(orderItem -> {
                    BigDecimal quantity = BigDecimal.valueOf(orderItem.getQuantity());
                    return orderItem.getPrice().multiply(quantity);
                })
                .reduce(BigDecimal::add)
                .orElseThrow(() -> new EntityNotFoundException(
                        localeService.getMessage("exception.order.total")
                ));
    }
}
