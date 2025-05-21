// Mapper-Interface mit MapStruct
package com.mischaboerner.saturatedserver.mapper;

import com.mischaboerner.saturatedserver.recipe.Recipe;
import com.mischaboerner.saturatedserver.recipe.RecipeDto;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

	RecipeDto toDto(Recipe recipe);

	Recipe toEntity(RecipeDto dto);

	List<RecipeDto> toDtoList(List<Recipe> recipes);

	List<Recipe> toEntityList(List<RecipeDto> recipeDtos);
}
