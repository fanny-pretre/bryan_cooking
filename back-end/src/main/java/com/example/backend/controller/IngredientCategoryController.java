package com.example.backend.controller;

import com.example.backend.model.input.IngredientCategoryInput;
import com.example.backend.model.input.IngredientCategoryInputEdit;
import com.example.backend.model.response.IngredientCategoryResponse;
import com.example.backend.service.IngredientCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ingredientCategory")
public class IngredientCategoryController {

    private final IngredientCategoryService ingredientCategoryService;

    @GetMapping
    public ResponseEntity<List<IngredientCategoryResponse>> getAllIngredientCategories() {

        return ResponseEntity.ok(ingredientCategoryService.getAllIngredientsCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientCategoryResponse> findIngredientCategoryById(@PathVariable String id) {

        return ResponseEntity.ok(ingredientCategoryService.findIngredientCategoryById(new BigInteger(id)));
    }

    @PostMapping
    public ResponseEntity<IngredientCategoryResponse> createIngredientCategory(@Valid @RequestBody IngredientCategoryInput ingredientCategoryInput) {

        return ResponseEntity.ok(ingredientCategoryService.createIngredientCategory(ingredientCategoryInput));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientCategoryResponse> editIngredientCategory(@Valid @RequestBody IngredientCategoryInputEdit ingredientCategoryInputEdit, @PathVariable String id) {

        return ResponseEntity.ok(ingredientCategoryService.editIngredientCategory(ingredientCategoryInputEdit, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredientCategory(@PathVariable String id) {

        ingredientCategoryService.deleteIngredientCategory(id);
        return ResponseEntity.noContent().build();
    }
}
