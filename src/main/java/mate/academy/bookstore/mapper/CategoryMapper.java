package mate.academy.bookstore.mapper;

import mate.academy.bookstore.config.MapperConfig;
import mate.academy.bookstore.dto.CategoryDto;
import mate.academy.bookstore.dto.CategoryRequestDto;
import mate.academy.bookstore.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {
    CategoryDto toDto(Category category);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "deleted", ignore = true)
    })
    Category toModel(CategoryRequestDto dto);
}
