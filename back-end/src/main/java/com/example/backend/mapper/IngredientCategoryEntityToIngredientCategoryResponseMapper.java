package com.example.backend.mapper;

import com.example.backend.model.entity.IngredientCategoryEntity;
import com.example.backend.model.response.IngredientCategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class IngredientCategoryEntityToIngredientCategoryResponseMapper {

    public IngredientCategoryResponse mapper (IngredientCategoryEntity ingredientCategoryEntity) {
        return IngredientCategoryResponse.builder()
                .id(ingredientCategoryEntity.getId())
                .name(ingredientCategoryEntity.getName())
                .displayOrder(ingredientCategoryEntity.getDisplay_order())
                .build();
    }
}
