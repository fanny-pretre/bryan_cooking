package com.example.backend.service;

import com.example.backend.exception.BadRequest;
import com.example.backend.exception.DataNotFound;
import com.example.backend.mapper.ingredient.IngredientResponseToIngredientEntityMapper;
import com.example.backend.mapper.meal.MealEntityToMealResponseMapper;
import com.example.backend.mapper.meal.MealInputToMealEntityMapper;
import com.example.backend.mapper.mealCategory.MealCategoryResponseToMealCategoryEntityMapper;
import com.example.backend.model.entity.MealEntity;
import com.example.backend.model.input.MealInput;
import com.example.backend.model.input.MealInputEdit;
import com.example.backend.model.response.IngredientResponse;
import com.example.backend.model.response.MealCategoryResponse;
import com.example.backend.model.response.MealResponse;
import com.example.backend.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {

    private final MealRepository mealRepository;

    private final MealCategoryService mealCategoryService;
    private final IngredientService ingredientService;

    private final MealEntityToMealResponseMapper mealEntityToMealResponseMapper;
    private final MealInputToMealEntityMapper mealInputToEntityMapper;
    private final MealCategoryResponseToMealCategoryEntityMapper mealCategoryResponseToEntityMapper;
    private final IngredientResponseToIngredientEntityMapper ingredientResponseToEntityMapper;


    public List<MealResponse> getAllMeals() {

        List<MealEntity> meals = mealRepository.findAll();

        return meals.stream()
                .map(mealEntityToMealResponseMapper::mealMapper)
                .toList();
    }

    public MealResponse findMealById(String id) {

        MealEntity meal = mealRepository.findById(new BigInteger(id))
                .orElseThrow(() ->
                        new DataNotFound("meal", id));

        return mealEntityToMealResponseMapper.mealMapper(meal);
    }

    public MealResponse createMeal(MealInput mealInput) {

        List<MealCategoryResponse> categories = mealCategoryService.findMealCategoryByIds(mealInput.categoryIds());
        List<IngredientResponse> ingredients= ingredientService.findIngredientByIds(mealInput.ingredientIds());

        if (categories.isEmpty() || ingredients.isEmpty())
        {
           throw new BadRequest("La catégorie ou les ingrédients ne peuvent pas être vides.");
        }

        MealEntity savedEntity = mealRepository.save(mealInputToEntityMapper
                .mealInputToMealEntityMapper(mealInput, categories, ingredients));

        return mealEntityToMealResponseMapper.mealMapper(savedEntity);
    }

    public MealResponse editMeal(MealInputEdit mealInputEdit, String id) {

        findMealById(id);
        List<MealCategoryResponse> categories = mealCategoryService.findMealCategoryByIds(mealInputEdit.categoryIds());
        List<IngredientResponse> ingredients= ingredientService.findIngredientByIds(mealInputEdit.ingredientIds());

        MealEntity updatedEntity = mealRepository.save(
                MealEntity.builder()
                        .id(new BigInteger(id))
                        .name(mealInputEdit.name())
                        .imageUrl(mealInputEdit.imageUrl())
                        .season(mealInputEdit.season())
                        .mealCategories(categories.stream().map(mealCategoryResponseToEntityMapper::mapper).toList())
                        .ingredients(ingredients.stream().map(ingredientResponseToEntityMapper::ingredientResponseToIngredientEntityMapper).toList())
                        .build()
        );

        return mealEntityToMealResponseMapper.mealMapper(updatedEntity);
    }

    public void deleteIngredient(String id) {
        MealEntity entite = mealRepository.findById(new BigInteger(id))
                .orElseThrow(() ->
                        new DataNotFound("meal", id));

        mealRepository.delete(entite);
    }
}
