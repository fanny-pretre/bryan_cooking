package com.example.backend.controller;

import com.example.backend.model.input.IngredientInput;
import com.example.backend.model.input.IngredientInputEdit;
import com.example.backend.model.response.IngredientResponse;
import com.example.backend.service.IngredientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<IngredientResponse>> getAllIngredients() {

        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientResponse> findIngredientById(@PathVariable String id) {

        return ResponseEntity.ok(ingredientService.findIngredientById(id));
    }

    @PostMapping
    public ResponseEntity<IngredientResponse> createIngredient(@Valid @RequestBody IngredientInput ingredientInput) {

        return ResponseEntity.ok(ingredientService.createIngredient(ingredientInput));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientResponse> editIngredient(@Valid @RequestBody IngredientInputEdit ingredientInputEdit, @PathVariable String id) {

        return ResponseEntity.ok(ingredientService.editIngredient(ingredientInputEdit, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable String id) {

        ingredientService.deleteIngredient(id);
        return ResponseEntity.noContent().build();
    }
}
