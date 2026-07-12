package com.example.backend.mapper.ingredientCategory;

import com.example.backend.model.entity.IngredientCategoryEntity;
import com.example.backend.model.input.IngredientCategoryInput;
import org.springframework.stereotype.Component;

@Component
public class IngredientCategoryInputToIngredientCategoryEntityMapper {

   public IngredientCategoryEntity mapper(IngredientCategoryInput ingredientCategoryInput) {
        return IngredientCategoryEntity.builder()
                .name(ingredientCategoryInput.name())
                .display_order(ingredientCategoryInput.displayOrder())
                .build();
    }
}
