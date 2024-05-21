package mate.academy.bookstore.mapper;

import mate.academy.bookstore.config.MapperConfig;
import mate.academy.bookstore.dto.BookDto;
import mate.academy.bookstore.dto.BookDtoWithoutCategoryIds;
import mate.academy.bookstore.dto.BookRequestDto;
import mate.academy.bookstore.model.Book;
import mate.academy.bookstore.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    @Mappings({
            @Mapping(source = "categories", target = "categoryIds",
                    qualifiedByName = "categoryToId")
    })
    BookDto toDto(Book book);

    @Mappings({
            @Mapping(source = "categories", target = "categories"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "deleted", ignore = true)
    })
    Book toModel(BookRequestDto dto);

    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);

    @Named("categoryToId")
    default Long categoryToId(Category category) {
        return category.getId();
    }
}
