package com.example.backend.model.response;

import lombok.Builder;

import java.math.BigInteger;

@Builder
public record GroceryItemResponse(
        BigInteger id,
        IngredientResponse ingredient,
        String name,
        String customLabel,
        Integer quantity,
        Boolean checked
) {}