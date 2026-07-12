package com.example.backend.mapper.ingredient;

import com.example.backend.mapper.ingredientCategory.IngredientCategoryResponseToIngredientCategoryEntityMapper;
import com.example.backend.model.entity.IngredientEntity;
import com.example.backend.model.response.IngredientResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IngredientResponseToIngredientEntityMapper {

    private IngredientCategoryResponseToIngredientCategoryEntityMapper ingredientCategoryResponseToEntityMapper;

    public IngredientEntity ingredientResponseToIngredientEntityMapper(IngredientResponse ingredientResponse) {

        return IngredientEntity.builder().
                id(ingredientResponse.id())
                .name(ingredientResponse.name())
                .image_url(ingredientResponse.imageUrl())
                .ingredientCategory(ingredientCategoryResponseToEntityMapper.mapper(ingredientResponse.category()))
                .build();
    }
}
