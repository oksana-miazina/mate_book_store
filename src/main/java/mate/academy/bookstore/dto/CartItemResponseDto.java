package mate.academy.bookstore.dto;

import lombok.Data;

@Data
public class CartItemResponseDto {
    private Long bookId;
    private String bookTitle;
    private int quantity;
}
