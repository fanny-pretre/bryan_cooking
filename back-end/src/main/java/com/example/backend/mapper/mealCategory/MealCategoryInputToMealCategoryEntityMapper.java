package com.example.backend.mapper.mealCategory;

import com.example.backend.model.entity.MealCategoryEntity;
import com.example.backend.model.input.MealCategoryInput;
import org.springframework.stereotype.Component;

@Component
public class MealCategoryInputToMealCategoryEntityMapper {

   public MealCategoryEntity mapper(MealCategoryInput mealCategoryInput) {
        return MealCategoryEntity.builder()
                .name(mealCategoryInput.name())
                .build();
    }
}
