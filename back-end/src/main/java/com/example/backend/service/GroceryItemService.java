package com.example.backend.service;

import com.example.backend.exception.DataNotFound;
import com.example.backend.mapper.groceryItem.GroceryItemEntityToGroceryItemResponseMapper;
import com.example.backend.mapper.groceryItem.GroceryItemInputToGroceryItemEntityMapper;
import com.example.backend.mapper.groceryList.GroceryListResponseToGroceryListEntityMapper;
import com.example.backend.mapper.ingredient.IngredientResponseToIngredientEntityMapper;
import com.example.backend.model.entity.GroceryItemEntity;
import com.example.backend.model.input.GroceryItemInput;
import com.example.backend.model.input.GroceryItemInputEdit;
import com.example.backend.model.response.GroceryItemResponse;
import com.example.backend.model.response.GroceryListResponse;
import com.example.backend.model.response.IngredientResponse;
import com.example.backend.repository.GroceryItemRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroceryItemService {

    private final GroceryItemEntityToGroceryItemResponseMapper groceryItemEntityToGroceryItemResponseMapper;
    private final GroceryItemRepository groceryItemRepository;
    private final IngredientService ingredientService;
    private final GroceryListService groceryListService;
    private final GroceryItemInputToGroceryItemEntityMapper groceryItemInputToGroceryItemEntityMapper;
    private final GroceryListResponseToGroceryListEntityMapper groceryListResponseToGroceryListEntityMapper;
    private final IngredientResponseToIngredientEntityMapper ingredientResponseToIngredientEntityMapper;

    public List<GroceryItemResponse> getAllGroceryItems() {

        List<GroceryItemEntity> groceryItems = groceryItemRepository.findAll();

        return groceryItems.stream()
                .map(groceryItemEntityToGroceryItemResponseMapper::mapper)
                .toList();
    }

    public GroceryItemResponse findGroceryItemById(BigInteger id) {

      return groceryItemEntityToGroceryItemResponseMapper.mapper(findById(id));
    }

    public GroceryItemResponse createGroceryItem(@Valid GroceryItemInput groceryItemInput) {

        IngredientResponse ingredient= ingredientService.findIngredientById(groceryItemInput.ingredientId());
        GroceryListResponse groceryList = groceryListService.findGroceryListById(groceryItemInput.groceryListId());

        GroceryItemEntity savedEntity = groceryItemRepository.save(
                groceryItemInputToGroceryItemEntityMapper.mapper(groceryItemInput, ingredient, groceryList));


        return groceryItemEntityToGroceryItemResponseMapper.mapper(savedEntity);
    }

    public GroceryItemResponse editGroceryItem(GroceryItemInputEdit groceryItemInputEdit, BigInteger id) {

        findGroceryItemById(id);
        IngredientResponse ingredient= ingredientService.findIngredientById(groceryItemInputEdit.ingredientId());
        GroceryListResponse groceryList = groceryListService.findGroceryListById(groceryItemInputEdit.groceryListId());

        GroceryItemEntity updatedEntity = groceryItemRepository.save(
                GroceryItemEntity.builder()
                        .id(id)
                        .groceryList(groceryListResponseToGroceryListEntityMapper.mapper(groceryList))
                        .ingredient(ingredientResponseToIngredientEntityMapper.ingredientResponseToIngredientEntityMapper(ingredient))
                        .customLabel(groceryItemInputEdit.customLabel())
                        .quantity(groceryItemInputEdit.quantity())
                        .checked(groceryItemInputEdit.checked())
                        .build()
        );

        return groceryItemEntityToGroceryItemResponseMapper.mapper(updatedEntity);
    }

    public void deleteGroceryItem(BigInteger id) {

        groceryItemRepository.delete(findById(id));
    }

    private GroceryItemEntity findById(BigInteger id) {
        return groceryItemRepository.findById(id)
                .orElseThrow(() ->
                        new DataNotFound("groceryItem", id));
    }
}
