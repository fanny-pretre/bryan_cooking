package com.example.backend.service;

import com.example.backend.exception.DataNotFound;
import com.example.backend.mapper.mealCategory.MealCategoryEntityToMealCategoryResponseMapper;
import com.example.backend.mapper.mealCategory.MealCategoryInputToMealCategoryEntityMapper;
import com.example.backend.model.entity.MealCategoryEntity;
import com.example.backend.model.input.MealCategoryInput;
import com.example.backend.model.input.MealCategoryInputEdit;
import com.example.backend.model.response.MealCategoryResponse;
import com.example.backend.repository.MealCategoryRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@AllArgsConstructor
public class MealCategoryService {

    private final MealCategoryRepository mealCategoryRepository;
    private final MealCategoryEntityToMealCategoryResponseMapper mealCategoryEntityMapper;
    private final MealCategoryInputToMealCategoryEntityMapper mealCategoryInputToEntityMapper;

    public List<MealCategoryResponse> getAllMealsCategories() {
        List<MealCategoryEntity> mealCategories = mealCategoryRepository.findAll();

        return mealCategories.stream()
                .map(mealCategoryEntityMapper::mealCategoryMapper)
                .toList();
    }

    public MealCategoryResponse findMealCategoryById(BigInteger id) {
        MealCategoryEntity mealCategoryEntity = mealCategoryRepository.findById(id)
                .orElseThrow(() ->
                        new DataNotFound("mealCategory", id));
        return mealCategoryEntityMapper.mealCategoryMapper(mealCategoryEntity);
    }

    public List<MealCategoryResponse> findMealCategoryByIds(List<BigInteger> ids) {

        List<MealCategoryEntity> mealCategoryEntities = mealCategoryRepository.findAllById(ids);

        return  mealCategoryEntities.stream()
                .map(mealCategoryEntityMapper::mealCategoryMapper)
                .toList();
    }

    public MealCategoryResponse createMealCategory(@Valid MealCategoryInput mealCategoryInput) {

        MealCategoryEntity entity = mealCategoryInputToEntityMapper.mapper(mealCategoryInput);
        MealCategoryEntity savedEntity = mealCategoryRepository.save(entity);

        return mealCategoryEntityMapper.mealCategoryMapper(savedEntity);
    }

    public MealCategoryResponse editMealCategory(MealCategoryInputEdit mealCategoryInputEdit, String id) {

        MealCategoryEntity updatedEntity = mealCategoryRepository.save(
                MealCategoryEntity.builder()
                        .id(new BigInteger(id))
                        .name(mealCategoryInputEdit.name())
                        .build()
        );

        return mealCategoryEntityMapper.mealCategoryMapper(updatedEntity);
    }

    public void deleteMealCategory(String id) {
        MealCategoryEntity entite = mealCategoryRepository.findById(new BigInteger(id))
                .orElseThrow(() ->
                        new DataNotFound("meal catégorie", id));

        mealCategoryRepository.delete(entite);
    }
}


