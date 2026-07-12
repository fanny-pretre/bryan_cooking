package com.example.backend.service;

import com.example.backend.mapper.mealCategory.MealCategoryEntityToMealCategoryResponseMapper;
import com.example.backend.model.entity.MealCategoryEntity;
import com.example.backend.model.response.MealCategoryResponse;
import com.example.backend.repository.MealCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@AllArgsConstructor
public class MealCategoryService {

    private final MealCategoryRepository mealCategoryRepository;
    private final MealCategoryEntityToMealCategoryResponseMapper mealCategoryEntityMapper;

    public List<MealCategoryResponse> findMealCategoryByIds(List<BigInteger> ids) {

        List<MealCategoryEntity> mealCategoryEntities = mealCategoryRepository.findAllById(ids);

        return  mealCategoryEntities.stream()
                .map(mealCategoryEntityMapper::mealCategoryMapper)
                .toList();
    }
}