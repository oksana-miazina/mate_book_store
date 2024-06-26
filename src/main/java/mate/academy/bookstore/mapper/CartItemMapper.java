package mate.academy.bookstore.mapper;

import mate.academy.bookstore.config.MapperConfig;
import mate.academy.bookstore.dto.CartItemRequestDto;
import mate.academy.bookstore.dto.CartItemResponseDto;
import mate.academy.bookstore.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(config = MapperConfig.class)
public interface CartItemMapper {
    @Mappings({
            @Mapping(source = "book.id", target = "bookId"),
            @Mapping(source = "book.title", target = "bookTitle")
    })
    CartItemResponseDto toDto(CartItem cartItem);

    @Mappings({
            @Mapping(source = "bookId", target = "book.id")
    })
    CartItem toModel(CartItemRequestDto dto);
}
