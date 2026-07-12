package com.example.backend.mapper.ingredient;

import com.example.backend.mapper.ingredientCategory.IngredientCategoryEntityToIngredientCategoryResponseMapper;
import com.example.backend.model.entity.IngredientEntity;
import com.example.backend.model.response.IngredientResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IngredientEntityToIngredientResponseMapper {

    private IngredientCategoryEntityToIngredientCategoryResponseMapper ingredientCategoryMapper;

    public IngredientResponse ingredientMapper(IngredientEntity ingredientEntity) {
        return IngredientResponse.builder()
                .id(ingredientEntity.getId())
                .name(ingredientEntity.getName())
                .imageUrl(ingredientEntity.getImage_url())
                .category(ingredientCategoryMapper.mapper(ingredientEntity.getIngredientCategory()))
                .build();
    }
}
