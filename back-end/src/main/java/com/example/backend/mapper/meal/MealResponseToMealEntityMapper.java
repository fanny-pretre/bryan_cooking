package com.example.backend.mapper.meal;

import com.example.backend.mapper.ingredient.IngredientResponseToIngredientEntityMapper;
import com.example.backend.mapper.mealCategory.MealCategoryResponseToMealCategoryEntityMapper;
import com.example.backend.model.entity.MealEntity;
import com.example.backend.model.response.MealResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MealResponseToMealEntityMapper {

    private final IngredientResponseToIngredientEntityMapper ingredientResponseToIngredientEntityMapper;
    private MealCategoryResponseToMealCategoryEntityMapper mealCategoryResponseToMealCategoryEntityMapper;

    public MealEntity mapper(MealResponse mealResponse) {
        return MealEntity.builder()
                .id(mealResponse.id())
                .name(mealResponse.name())
                .imageUrl(mealResponse.imageUrl())
                .season(mealResponse.season())
                .mealCategories(mealResponse.mealCategories().stream().map(mealCategoryResponseToMealCategoryEntityMapper::mapper).toList())
                .ingredients(mealResponse.ingredients().stream().map(ingredientResponseToIngredientEntityMapper::ingredientResponseToIngredientEntityMapper).toList())
                .build();
    }
}
