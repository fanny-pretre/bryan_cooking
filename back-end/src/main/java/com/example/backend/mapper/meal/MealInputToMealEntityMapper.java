package com.example.backend.mapper.meal;

import com.example.backend.mapper.ingredient.IngredientResponseToIngredientEntityMapper;
import com.example.backend.mapper.mealCategory.MealCategoryResponseToMealCategoryEntityMapper;
import com.example.backend.model.entity.MealEntity;
import com.example.backend.model.input.MealInput;
import com.example.backend.model.response.IngredientResponse;
import com.example.backend.model.response.MealCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class MealInputToMealEntityMapper {

    private final MealCategoryResponseToMealCategoryEntityMapper mealCategoryResponseToEntityMapper;
    private final IngredientResponseToIngredientEntityMapper ingredientResponseToEntityMapper;

    public MealEntity mealInputToMealEntityMapper(MealInput mealInput, List<MealCategoryResponse> categories, List<IngredientResponse> ingredients) {

       return MealEntity.builder()
                .name(mealInput.name())
                .image_url(mealInput.imageUrl())
                .season(mealInput.season())
                .mealCategories(categories.stream().map(mealCategoryResponseToEntityMapper::mapper).toList())
                .ingredients(ingredients.stream().map(ingredientResponseToEntityMapper::ingredientResponseToIngredientEntityMapper).toList())
                .build();
    }
}
