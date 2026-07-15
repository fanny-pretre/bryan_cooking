package com.example.backend.mapper.meal;

import com.example.backend.mapper.ingredient.IngredientEntityToIngredientResponseMapper;
import com.example.backend.mapper.mealCategory.MealCategoryEntityToMealCategoryResponseMapper;
import com.example.backend.model.entity.MealEntity;
import com.example.backend.model.response.MealResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MealEntityToMealResponseMapper {

    private MealCategoryEntityToMealCategoryResponseMapper mapper;
    private IngredientEntityToIngredientResponseMapper ingredientMapper;

    public MealResponse mealMapper(MealEntity mealEntity) {
        return MealResponse.builder()
                .id(mealEntity.getId())
                .name(mealEntity.getName())
                .imageUrl(mealEntity.getImageUrl())
                .season(mealEntity.getSeason())
                .mealCategories(
                        mealEntity.getMealCategories().stream()
                                .map(mapper::mealCategoryMapper)
                                .toList()
                )
                .ingredients(
                        mealEntity.getIngredients().stream()
                                .map(ingredientMapper::ingredientMapper)
                                .toList()
                )
                .build();
    }
}
