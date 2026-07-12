package com.example.backend.service;

import com.example.backend.exception.DataNotFound;
import com.example.backend.mapper.ingredientCategory.IngredientCategoryEntityToIngredientCategoryResponseMapper;
import com.example.backend.model.entity.IngredientCategoryEntity;
import com.example.backend.model.response.IngredientCategoryResponse;
import com.example.backend.repository.IngredientCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@AllArgsConstructor
public class IngredientCategoryService {

    private final IngredientCategoryRepository ingredientCategoryRepository;
    private final IngredientCategoryEntityToIngredientCategoryResponseMapper ingredientCategoryEntityMapper;

    public IngredientCategoryResponse getById(BigInteger id) {
        IngredientCategoryEntity ingredientCategoryEntity = ingredientCategoryRepository.findById(id)
                .orElseThrow(() ->
                        new DataNotFound("ingredientCategory", id));
        return ingredientCategoryEntityMapper.mapper(ingredientCategoryEntity);
    }
}