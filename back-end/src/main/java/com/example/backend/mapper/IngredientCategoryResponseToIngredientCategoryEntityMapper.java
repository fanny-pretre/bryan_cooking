package com.example.backend.mapper;

import com.example.backend.model.entity.IngredientCategoryEntity;
import com.example.backend.model.response.IngredientCategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class IngredientCategoryResponseToIngredientCategoryEntityMapper {
    public IngredientCategoryEntity mapper(IngredientCategoryResponse ingredientCategoryResponse) {
        return IngredientCategoryEntity.builder()
                .id(ingredientCategoryResponse.id())
                .name(ingredientCategoryResponse.name())
                .display_order(ingredientCategoryResponse.displayOrder())
                .build();
    }
}
