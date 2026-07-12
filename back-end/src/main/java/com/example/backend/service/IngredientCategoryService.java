package com.example.backend.service;

import com.example.backend.exception.DataNotFound;
import com.example.backend.mapper.ingredientCategory.IngredientCategoryEntityToIngredientCategoryResponseMapper;
import com.example.backend.mapper.ingredientCategory.IngredientCategoryInputToIngredientCategoryEntityMapper;
import com.example.backend.model.entity.IngredientCategoryEntity;
import com.example.backend.model.input.IngredientCategoryInput;
import com.example.backend.model.input.IngredientCategoryInputEdit;
import com.example.backend.model.response.IngredientCategoryResponse;
import com.example.backend.repository.IngredientCategoryRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@AllArgsConstructor
public class IngredientCategoryService {

    private final IngredientCategoryRepository ingredientCategoryRepository;
    private final IngredientCategoryEntityToIngredientCategoryResponseMapper ingredientCategoryEntityMapper;
    private final IngredientCategoryInputToIngredientCategoryEntityMapper ingredientCategoryInputToIngredientCategoryEntityMapper;

    public List<IngredientCategoryResponse> getAllIngredientsCategories() {
        List<IngredientCategoryEntity> ingredientCategories = ingredientCategoryRepository.findAll();

        return ingredientCategories.stream()
                .map(ingredientCategoryEntityMapper::mapper)
                .toList();
    }

    public IngredientCategoryResponse findIngredientCategoryById(BigInteger id) {
        IngredientCategoryEntity ingredientCategoryEntity = ingredientCategoryRepository.findById(id)
                .orElseThrow(() ->
                        new DataNotFound("ingredientCategory", id));
        return ingredientCategoryEntityMapper.mapper(ingredientCategoryEntity);
    }

    public IngredientCategoryResponse createIngredientCategory(@Valid IngredientCategoryInput ingredientCategoryInput) {

        IngredientCategoryEntity entity = ingredientCategoryInputToIngredientCategoryEntityMapper.mapper(ingredientCategoryInput);
        IngredientCategoryEntity savedEntity = ingredientCategoryRepository.save(entity);

        return ingredientCategoryEntityMapper.mapper(savedEntity);
    }

    public IngredientCategoryResponse editIngredientCategory(IngredientCategoryInputEdit ingredientCategoryInputEdit, String id) {

        IngredientCategoryEntity updatedEntity = ingredientCategoryRepository.save(
                IngredientCategoryEntity.builder()
                        .id(new BigInteger(id))
                        .name(ingredientCategoryInputEdit.name())
                        .display_order(ingredientCategoryInputEdit.displayOrder())
                        .build()
        );

        return ingredientCategoryEntityMapper.mapper(updatedEntity);
    }

    public void deleteIngredientCategory(String id) {
        IngredientCategoryEntity entite = ingredientCategoryRepository.findById(new BigInteger(id))
                .orElseThrow(() ->
                        new DataNotFound("ingredient catégorie", id));

        ingredientCategoryRepository.delete(entite);
    }
}

