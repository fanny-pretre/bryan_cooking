package com.example.backend.mapper;

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
                .image_url(ingredientEntity.getImage_url())
                .category(ingredientCategoryMapper.mapper(ingredientEntity.getIngredientCategory()))
                .build();
    }
}
