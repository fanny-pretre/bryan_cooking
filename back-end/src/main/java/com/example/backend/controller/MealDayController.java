package com.example.backend.controller;

import com.example.backend.model.input.MealDayInput;
import com.example.backend.model.input.MealDayInputEdit;
import com.example.backend.model.response.MealDayResponse;
import com.example.backend.service.MealDayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mealDay")
public class MealDayController {

    private final MealDayService mealDayService;

    @GetMapping
    public ResponseEntity<List<MealDayResponse>> getAllMealDays() {
        return ResponseEntity.ok(mealDayService.getAllMealDays());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealDayResponse> findMealDayById(@PathVariable String id) {
        return ResponseEntity.ok(mealDayService.findMealDayById(new BigInteger(id)));
    }

    @PostMapping
    public ResponseEntity<MealDayResponse> createMealDay(@Valid @RequestBody MealDayInput mealDayInput) {
        return ResponseEntity.ok(mealDayService.createMealDay(mealDayInput));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MealDayResponse> editMealDay(@Valid @RequestBody MealDayInputEdit mealDayInputEdit, @PathVariable String id) {
        return ResponseEntity.ok(mealDayService.editMealDay(mealDayInputEdit, new BigInteger(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMealDay(@PathVariable String id) {
        mealDayService.deleteMealDay(new BigInteger(id));
        return ResponseEntity.noContent().build();
    }
}
