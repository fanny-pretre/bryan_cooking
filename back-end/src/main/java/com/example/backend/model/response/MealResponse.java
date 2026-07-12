
package com.example.backend.model.response;


import lombok.Builder;

import java.math.BigInteger;
import java.util.List;

@Builder
public record MealResponse(
        BigInteger id,
        String name,
        String imageUrl,
        String season,
        List<MealCategoryResponse> mealCategories,
        List<IngredientResponse> ingredients) {
}
