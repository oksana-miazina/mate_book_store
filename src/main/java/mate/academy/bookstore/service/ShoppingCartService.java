package mate.academy.bookstore.service;

import mate.academy.bookstore.dto.ShoppingCartDto;
import mate.academy.bookstore.dto.ShoppingCartRequestDto;
import mate.academy.bookstore.model.User;

public interface ShoppingCartService {
    void createFor(User user);

    ShoppingCartDto save(ShoppingCartRequestDto dto, User user);

    ShoppingCartDto getByUserId(Long id);

    void deleteCartItem(Long bookId, Long userId);
}
