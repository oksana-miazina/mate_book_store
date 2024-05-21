package mate.academy.bookstore.service;

import mate.academy.bookstore.dto.ShoppingCartDto;
import mate.academy.bookstore.dto.ShoppingCartRequestDto;
import mate.academy.bookstore.model.CartItemKey;
import mate.academy.bookstore.model.User;

public interface ShoppingCartService {
    ShoppingCartDto save(ShoppingCartRequestDto dto, User user);

    ShoppingCartDto getByUserId(Long id);

    void deleteCartItemById(CartItemKey id);
}
