package com.example.backend.mapper.groceryItem;

import com.example.backend.mapper.groceryList.GroceryListResponseToGroceryListEntityMapper;
import com.example.backend.mapper.ingredient.IngredientResponseToIngredientEntityMapper;
import com.example.backend.model.entity.GroceryItemEntity;
import com.example.backend.model.input.GroceryItemInput;
import com.example.backend.model.response.GroceryListResponse;
import com.example.backend.model.response.IngredientResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GroceryItemInputToGroceryItemEntityMapper {


    private final GroceryListResponseToGroceryListEntityMapper groceryListResponseToGroceryListEntityMapper;
    private final IngredientResponseToIngredientEntityMapper ingredientResponseToIngredientEntityMapper;

    public GroceryItemEntity mapper(GroceryItemInput groceryItemInput, IngredientResponse ingredient, GroceryListResponse groceryList) {
        return GroceryItemEntity
                .builder()
                .groceryList(groceryListResponseToGroceryListEntityMapper.mapper(groceryList))
                .ingredient(ingredientResponseToIngredientEntityMapper.ingredientResponseToIngredientEntityMapper(ingredient))
                .customLabel(groceryItemInput.customLabel())
                .quantity(groceryItemInput.quantity())
                .checked(groceryItemInput.checked())
                .build();
    }
}
