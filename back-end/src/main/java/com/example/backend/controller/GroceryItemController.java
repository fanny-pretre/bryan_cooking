package com.example.backend.controller;

import com.example.backend.model.input.GroceryItemInput;
import com.example.backend.model.input.GroceryItemInputEdit;
import com.example.backend.model.response.GroceryItemResponse;
import com.example.backend.service.GroceryItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groceryItem")
public class GroceryItemController {

    private final GroceryItemService groceryItemService;

    @GetMapping
    public ResponseEntity<List<GroceryItemResponse>> getAllGroceryItems() {

        return ResponseEntity.ok(groceryItemService.getAllGroceryItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItemResponse> findGroceryItemById(@PathVariable String id) {
        return ResponseEntity.ok(groceryItemService.findGroceryItemById(new BigInteger(id)));
    }

    @PostMapping
    public ResponseEntity<GroceryItemResponse> createGroceryItem(@Valid @RequestBody GroceryItemInput groceryItemInput) {
        return ResponseEntity.ok(groceryItemService.createGroceryItem(groceryItemInput));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItemResponse> editGroceryItem(@Valid @RequestBody GroceryItemInputEdit groceryItemInputEdit, @PathVariable String id) {
        return ResponseEntity.ok(groceryItemService.editGroceryItem(groceryItemInputEdit, new BigInteger(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable String id) {
        groceryItemService.deleteGroceryItem(new BigInteger(id));
        return ResponseEntity.noContent().build();
    }
}
