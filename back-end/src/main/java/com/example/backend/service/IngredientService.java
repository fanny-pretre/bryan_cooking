package com.example.backend.service;

import com.example.backend.exception.DataNotFound;
import com.example.backend.mapper.ingredientCategory.IngredientCategoryResponseToIngredientCategoryEntityMapper;
import com.example.backend.mapper.ingredient.IngredientEntityToIngredientResponseMapper;
import com.example.backend.mapper.ingredient.IngredientInputToIngredientEntityMapper;
import com.example.backend.model.entity.IngredientEntity;
import com.example.backend.model.input.IngredientInput;
import com.example.backend.model.input.IngredientInputEdit;
import com.example.backend.model.response.IngredientCategoryResponse;
import com.example.backend.model.response.IngredientResponse;
import com.example.backend.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientEntityToIngredientResponseMapper ingredientEntityToIngredientResponseMapper;
    private final IngredientInputToIngredientEntityMapper ingredientInputToIngredientEntityMapper;
    private final IngredientCategoryService ingredientCategoryService;
    private final IngredientCategoryResponseToIngredientCategoryEntityMapper ingredientCategoryResponseToIngredientCategoryEntityMapper;

    public List<IngredientResponse> getAllIngredients() {

        List<IngredientEntity> ingredients = ingredientRepository.findAll();

        return ingredients.stream()
                .map(ingredientEntityToIngredientResponseMapper::ingredientMapper)
                .toList();
    }

    public IngredientResponse findIngredientById(String id) {

        IngredientEntity ingredient = ingredientRepository.findById(new BigInteger(id))
                .orElseThrow(() ->
                        new DataNotFound("ingredient", id));

        return ingredientEntityToIngredientResponseMapper.ingredientMapper(ingredient);
    }

    public List<IngredientResponse> findIngredientByIds(List<BigInteger> ids) {
        List<IngredientEntity> ingredients = ingredientRepository.findAllById(ids);

        return ingredients.stream().map(ingredientEntityToIngredientResponseMapper::ingredientMapper).toList();
    }

    public IngredientResponse createIngredient(IngredientInput ingredientInput) {

        IngredientCategoryResponse category = ingredientCategoryService.findIngredientCategoryById(ingredientInput.categoryId());

        IngredientEntity entity = ingredientInputToIngredientEntityMapper.mapper(ingredientInput, category);
        IngredientEntity savedEntity = ingredientRepository.save(entity);

        return ingredientEntityToIngredientResponseMapper.ingredientMapper(savedEntity);
    }


    public IngredientResponse editIngredient(IngredientInputEdit ingredientInputEdit, String id) {

        findIngredientById(id);
        IngredientCategoryResponse category = ingredientCategoryService.findIngredientCategoryById(ingredientInputEdit.categoryId());

        IngredientEntity updatedEntity = ingredientRepository.save(
                IngredientEntity.builder()
                        .id(new BigInteger(id))
                        .name(ingredientInputEdit.name())
                        .image_url(ingredientInputEdit.imageUrl())
                        .ingredientCategory(ingredientCategoryResponseToIngredientCategoryEntityMapper.mapper(category))
                        .build()
        );

        return ingredientEntityToIngredientResponseMapper.ingredientMapper(updatedEntity);
    }

    public void deleteIngredient(String id) {
        IngredientEntity entite = ingredientRepository.findById(new BigInteger(id))
                .orElseThrow(() ->
                        new DataNotFound("ingredient", id));

        ingredientRepository.delete(entite);
    }
}
