package com.example.backend.mapper.groceryItem;

import com.example.backend.mapper.ingredient.IngredientResponseToIngredientEntityMapper;
import com.example.backend.model.entity.GroceryItemEntity;
import com.example.backend.model.response.GroceryItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GroceryItemResponseToGroceryItemEntityMapper {

    private final IngredientResponseToIngredientEntityMapper ingredientResponseToIngredientEntityMapper;

    public GroceryItemEntity mapper(GroceryItemResponse groceryItemResponse) {


        return GroceryItemEntity.builder()
                .id(groceryItemResponse.id())
                .ingredient(ingredientResponseToIngredientEntityMapper.ingredientResponseToIngredientEntityMapper(groceryItemResponse.ingredient()))
                .customLabel(groceryItemResponse.customLabel())
                .quantity(groceryItemResponse.quantity())
                .checked(groceryItemResponse.checked())
                .build();
    }
}
