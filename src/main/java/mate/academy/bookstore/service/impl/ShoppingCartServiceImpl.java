package mate.academy.bookstore.service.impl;

import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mate.academy.bookstore.dto.ShoppingCartDto;
import mate.academy.bookstore.dto.ShoppingCartRequestDto;
import mate.academy.bookstore.exception.EntityNotFoundException;
import mate.academy.bookstore.mapper.ShoppingCartMapper;
import mate.academy.bookstore.model.CartItem;
import mate.academy.bookstore.model.CartItemKey;
import mate.academy.bookstore.model.ShoppingCart;
import mate.academy.bookstore.model.User;
import mate.academy.bookstore.repository.BookRepository;
import mate.academy.bookstore.repository.CartItemRepository;
import mate.academy.bookstore.repository.ShoppingCartRepository;
import mate.academy.bookstore.service.LocaleService;
import mate.academy.bookstore.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;
    private final ShoppingCartMapper shoppingCartMapper;
    private final LocaleService localeService;

    @Override
    public ShoppingCartDto save(ShoppingCartRequestDto dto, User user) {
        ShoppingCart shoppingCart = shoppingCartMapper.toModel(dto);
        shoppingCart.setUser(user);
        shoppingCart.setId(user.getId());

        validateCartBooksExistence(shoppingCart.getCartItems());

        shoppingCart.setCartItems(shoppingCart.getCartItems().stream()
                .peek(i -> i.getId().setShoppingCart(shoppingCart))
                .collect(Collectors.toSet())
        );

        ShoppingCart savedShoppingCart = shoppingCartRepository.save(shoppingCart);
        return shoppingCartMapper.toDto(savedShoppingCart);
    }

    @Override
    public ShoppingCartDto getByUserId(Long id) {
        ShoppingCart shoppingCart = shoppingCartRepository.getByUserId(id);
        return shoppingCartMapper.toDto(shoppingCart);
    }

    @Override
    public void deleteCartItemById(CartItemKey id) {
        cartItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        localeService.getMessage("exception.notfound.cartitem") + id
                ));
        cartItemRepository.deleteById(id);
    }

    private void validateCartBooksExistence(Set<CartItem> cartItems) {
        cartItems.forEach(i -> {
            Long bookId = i.getId().getBook().getId();
            boolean isBookExists = bookRepository.existsById(bookId);
            if (!isBookExists) {
                throw new EntityNotFoundException(
                        localeService.getMessage("exception.notfound.book") + bookId
                );
            }
        });
    }
}
