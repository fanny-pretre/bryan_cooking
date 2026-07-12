package com.example.backend.mapper.mealCategory;

import com.example.backend.model.entity.MealCategoryEntity;
import com.example.backend.model.response.MealCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MealCategoryEntityToMealCategoryResponseMapper {

    public MealCategoryResponse mealCategoryMapper(MealCategoryEntity mealCategoryEntity) {
        return MealCategoryResponse.builder()
                .id(mealCategoryEntity.getId())
                .name(mealCategoryEntity.getName())
                .build();
    }
}
