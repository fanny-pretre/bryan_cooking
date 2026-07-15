package com.example.backend.mapper.ingredient;

import com.example.backend.mapper.ingredientCategory.IngredientCategoryResponseToIngredientCategoryEntityMapper;
import com.example.backend.model.entity.IngredientEntity;
import com.example.backend.model.input.IngredientInput;
import com.example.backend.model.response.IngredientCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IngredientInputToIngredientEntityMapper {

    private final IngredientCategoryResponseToIngredientCategoryEntityMapper mapper;

    public IngredientEntity mapper(IngredientInput ingredientInput, IngredientCategoryResponse category) {
        return IngredientEntity.builder()
                .name(ingredientInput.name())
                .imageUrl(ingredientInput.imageUrl())
                .ingredientCategory(mapper.mapper(category))
                .build();
    }
}
