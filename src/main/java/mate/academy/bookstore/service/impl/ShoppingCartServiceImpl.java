package mate.academy.bookstore.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mate.academy.bookstore.dto.ShoppingCartDto;
import mate.academy.bookstore.dto.ShoppingCartRequestDto;
import mate.academy.bookstore.exception.EntityNotFoundException;
import mate.academy.bookstore.mapper.ShoppingCartMapper;
import mate.academy.bookstore.model.Book;
import mate.academy.bookstore.model.CartItemKey;
import mate.academy.bookstore.model.ShoppingCart;
import mate.academy.bookstore.model.User;
import mate.academy.bookstore.repository.BookRepository;
import mate.academy.bookstore.repository.CartItemRepository;
import mate.academy.bookstore.repository.ShoppingCartRepository;
import mate.academy.bookstore.service.LocaleService;
import mate.academy.bookstore.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;
    private final ShoppingCartMapper shoppingCartMapper;
    private final LocaleService localeService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createFor(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCart.setId(user.getId());
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    @Transactional
    public ShoppingCartDto save(ShoppingCartRequestDto dto, User user) {
        ShoppingCart shoppingCart = shoppingCartMapper.toModel(dto);
        shoppingCart.setUser(user);
        shoppingCart.setId(user.getId());

        shoppingCart.setCartItems(shoppingCart.getCartItems().stream()
                .peek(i -> i.getId().setShoppingCart(shoppingCart))
                .collect(Collectors.toSet())
        );

        ShoppingCart savedShoppingCart = shoppingCartRepository.saveAndFlush(shoppingCart);
        entityManager.refresh(savedShoppingCart);
        return shoppingCartMapper.toDto(savedShoppingCart);
    }

    @Override
    public ShoppingCartDto getByUserId(Long id) {
        ShoppingCart shoppingCart = shoppingCartRepository.getByUserId(id);
        return shoppingCartMapper.toDto(shoppingCart);
    }

    @Override
    public void deleteCartItem(Long bookId, Long userId) {
        ShoppingCart shoppingCart = new ShoppingCart(userId);
        Book book = new Book(bookId);
        CartItemKey id = new CartItemKey(shoppingCart, book);

        if (!cartItemRepository.existsById(id)) {
            throw new EntityNotFoundException(
                    localeService.getMessage("exception.notfound.cartitem") + bookId
            );
        }
        cartItemRepository.deleteById(id);
    }
}
