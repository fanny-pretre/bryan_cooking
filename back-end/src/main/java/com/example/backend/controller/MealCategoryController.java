package com.example.backend.controller;

import com.example.backend.model.input.MealCategoryInput;
import com.example.backend.model.input.MealCategoryInputEdit;
import com.example.backend.model.response.MealCategoryResponse;
import com.example.backend.service.MealCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mealCategory")
public class MealCategoryController {

    private final MealCategoryService mealCategoryService;

    @GetMapping
    public ResponseEntity<List<MealCategoryResponse>> getAllMealsCategories() {

        return ResponseEntity.ok(mealCategoryService.getAllMealsCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealCategoryResponse> findMealCategoryById(@PathVariable String id) {

        return ResponseEntity.ok(mealCategoryService.findMealCategoryById(new BigInteger(id)));
    }

    @PostMapping
    public ResponseEntity<MealCategoryResponse> createMealCategory(@Valid @RequestBody MealCategoryInput mealCategoryInput) {

        return ResponseEntity.ok(mealCategoryService.createMealCategory(mealCategoryInput));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MealCategoryResponse> editMealCategory(@Valid @RequestBody MealCategoryInputEdit mealCategoryInputEdit, @PathVariable String id) {

        return ResponseEntity.ok(mealCategoryService.editMealCategory(mealCategoryInputEdit, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMealCategory(@PathVariable String id) {

        mealCategoryService.deleteMealCategory(id);
        return ResponseEntity.noContent().build();
    }
}
