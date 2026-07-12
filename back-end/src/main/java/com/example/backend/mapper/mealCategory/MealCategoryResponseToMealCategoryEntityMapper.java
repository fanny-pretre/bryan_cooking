package com.example.backend.mapper.mealCategory;

import com.example.backend.model.entity.MealCategoryEntity;
import com.example.backend.model.response.MealCategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class MealCategoryResponseToMealCategoryEntityMapper {

    public MealCategoryEntity mapper(MealCategoryResponse mealCategoryResponse) {
        return MealCategoryEntity.builder()
                .id(mealCategoryResponse.id())
                .name(mealCategoryResponse.name())
                .build();
    }
}
