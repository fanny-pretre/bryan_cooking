package com.example.backend.mapper.groceryItem;

import com.example.backend.mapper.ingredient.IngredientEntityToIngredientResponseMapper;
import com.example.backend.model.entity.GroceryItemEntity;
import com.example.backend.model.response.GroceryItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GroceryItemEntityToGroceryItemResponseMapper {

    private final IngredientEntityToIngredientResponseMapper ingredientEntityToIngredientResponseMapper;

    public GroceryItemResponse mapper(GroceryItemEntity groceryItemEntity) {
        return GroceryItemResponse.builder()
                .id(groceryItemEntity.getId())
                .ingredient(ingredientEntityToIngredientResponseMapper.ingredientMapper(groceryItemEntity.getIngredient()))
                .name(groceryItemEntity.getIngredient().getName())
                .customLabel(groceryItemEntity.getCustomLabel())
                .quantity(groceryItemEntity.getQuantity())
                .checked(groceryItemEntity.getChecked())
                .build();
    }
}
