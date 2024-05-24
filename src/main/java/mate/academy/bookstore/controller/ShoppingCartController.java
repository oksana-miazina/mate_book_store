package mate.academy.bookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.bookstore.dto.ShoppingCartDto;
import mate.academy.bookstore.dto.ShoppingCartRequestDto;
import mate.academy.bookstore.model.User;
import mate.academy.bookstore.response.ErrorResponse;
import mate.academy.bookstore.response.ResponseHandler;
import mate.academy.bookstore.response.SuccessResponse;
import mate.academy.bookstore.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Shopping Cart Management", description = "Endpoints for managing shopping carts")
@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @GetMapping
    @Operation(summary = "Get user's shopping cart", description = "Get user's shopping cart")
    public SuccessResponse<ShoppingCartDto> getShoppingCart(@AuthenticationPrincipal User user) {
        return ResponseHandler.getSuccessResponse(
                shoppingCartService.getByUserId(user.getId()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new shopping cart", description = "Create a new shopping cart")
    public SuccessResponse<ShoppingCartDto> updateShoppingCart(
            @Valid @RequestBody ShoppingCartRequestDto dto, @AuthenticationPrincipal User user) {
        return ResponseHandler.getSuccessResponse(
                shoppingCartService.save(dto, user),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/cart-items/{bookId}")
    @Operation(summary = "Delete item from shopping cart",
            description = "Delete item from shopping cart")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "404", content =
                    { @Content(schema = @Schema(implementation = ErrorResponse.class)) }),
    })
    public void deleteBookFromCartById(@PathVariable Long bookId,
                                       @AuthenticationPrincipal User user) {
        shoppingCartService.deleteCartItem(bookId, user.getId());
    }
}
