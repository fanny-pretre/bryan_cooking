package com.example.backend.controller;

import com.example.backend.model.input.MealInput;
import com.example.backend.model.input.MealInputEdit;
import com.example.backend.model.pathVariables.MealSearchCriteria;
import com.example.backend.model.response.MealResponse;
import com.example.backend.service.MealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/meal")
public class MealController {

    private final MealService mealService;

    @GetMapping()
    public ResponseEntity<Page<MealResponse>> getAllMeals(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String season,
            @RequestParam(required = false) List<BigInteger> categoryIds,
            @RequestParam(required = false) List<BigInteger> ingredientIds,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        MealSearchCriteria criteria = MealSearchCriteria.builder()
                .name(name)
                .season(season)
                .categoryIds(categoryIds)
                .ingredientIds(ingredientIds)
                .build();

        Pageable pageable = PageRequest.of(page, size);

        return ResponseEntity.ok(mealService.getAllMeals(criteria, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealResponse> findMealById(@PathVariable String id) {
        return ResponseEntity.ok(mealService.findMealById(new BigInteger(id)));
    }

    @PostMapping
    public ResponseEntity<MealResponse> createMeal(@Valid @RequestBody MealInput mealInput) {
        return ResponseEntity.ok(mealService.createMeal(mealInput));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MealResponse> editMeal(@Valid @RequestBody MealInputEdit mealInputEdit, @PathVariable String id) {
        return ResponseEntity.ok(mealService.editMeal(mealInputEdit, new BigInteger(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeal(@PathVariable String id) {
        mealService.deleteMeal(new BigInteger(id));
        return ResponseEntity.noContent().build();
    }
}
