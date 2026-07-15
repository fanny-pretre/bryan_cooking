package com.example.backend.controller;

import com.example.backend.model.input.MealInput;
import com.example.backend.model.input.MealInputEdit;
import com.example.backend.model.response.MealResponse;
import com.example.backend.service.MealService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/meal")
public class MealController {

    private final MealService mealService;

    @GetMapping
    public ResponseEntity<List<MealResponse>> getAllMeals() {
        return ResponseEntity.ok(mealService.getAllMeals());
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
