package com.example.backend.controller;

import com.example.backend.model.input.GroceryListInput;
import com.example.backend.model.response.GroceryListResponse;
import com.example.backend.service.GroceryListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groceryList")
public class GroceryListController {

    private final GroceryListService groceryListService;

    @GetMapping
    public ResponseEntity<List<GroceryListResponse>> getAllGroceryLists() {

        return ResponseEntity.ok(groceryListService.getAllGroceryLists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryListResponse> findGroceryListById(@PathVariable String id) {
        return ResponseEntity.ok(groceryListService.findGroceryListById(new BigInteger(id)));
    }

    @PostMapping
    public ResponseEntity<GroceryListResponse> createGroceryItem(@Valid @RequestBody GroceryListInput groceryListInput) {
        return ResponseEntity.ok(groceryListService.createGroceryList(groceryListInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryList(@PathVariable String id) {
        groceryListService.deleteGroceryList(new BigInteger(id));
        return ResponseEntity.noContent().build();
    }
}
