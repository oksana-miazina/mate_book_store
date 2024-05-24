package mate.academy.bookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.bookstore.dto.OrderCreateRequestDto;
import mate.academy.bookstore.dto.OrderDto;
import mate.academy.bookstore.dto.OrderItemDto;
import mate.academy.bookstore.dto.OrderUpdateRequestDto;
import mate.academy.bookstore.model.User;
import mate.academy.bookstore.response.ErrorResponse;
import mate.academy.bookstore.response.ResponseHandler;
import mate.academy.bookstore.response.SuccessResponse;
import mate.academy.bookstore.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Order Management", description = "Endpoints for managing orders")
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    @Operation(summary = "Get all orders", description = "Get all orders")
    public SuccessResponse<List<OrderDto>> getAll(@AuthenticationPrincipal User user) {
        return ResponseHandler.getSuccessResponse(
                orderService.findAll(user)
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by id", description = "Get order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "404", content =
                    { @Content(schema = @Schema(implementation = ErrorResponse.class)) }),
    })
    public SuccessResponse<OrderDto> getOrderById(@PathVariable Long id,
                                                  @AuthenticationPrincipal User user) {
        return ResponseHandler.getSuccessResponse(
                orderService.getOrderById(id, user)
        );
    }

    @GetMapping("/{orderId}/items")
    @Operation(summary = "Get order items by order id", description = "Get order items by order id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "404", content =
                    { @Content(schema = @Schema(implementation = ErrorResponse.class)) }),
    })
    public SuccessResponse<List<OrderItemDto>> getOrderItemsByOrderId(
            @PathVariable Long orderId, @AuthenticationPrincipal User user) {
        return ResponseHandler.getSuccessResponse(
                orderService.getOrderItemsByOrderId(orderId, user)
        );
    }

    @GetMapping("/{orderId}/items/{itemId}")
    @Operation(summary = "Get order item by id", description = "Get order item by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", useReturnTypeSchema = true),
            @ApiResponse(responseCode = "404", content =
                    { @Content(schema = @Schema(implementation = ErrorResponse.class)) }),
    })
    public SuccessResponse<OrderItemDto> getOrderItemById(@PathVariable Long itemId,
                       @PathVariable Long orderId, @AuthenticationPrincipal User user) {
        return ResponseHandler.getSuccessResponse(
                orderService.getOrderItemById(itemId, orderId, user)
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new order", description = "Create a new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", useReturnTypeSchema = true)
    })
    public SuccessResponse<OrderDto> createOrder(@RequestBody @Valid OrderCreateRequestDto dto,
                                                 @AuthenticationPrincipal User user) {
        return ResponseHandler.getSuccessResponse(
                orderService.create(dto, user),
                HttpStatus.CREATED
        );
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update an existing order", description = "Update an existing order")
    public SuccessResponse<OrderDto> updateOrderById(@PathVariable Long id,
                                                  @RequestBody @Valid OrderUpdateRequestDto dto) {
        return ResponseHandler.getSuccessResponse(
                orderService.updateById(id, dto)
        );
    }
}
