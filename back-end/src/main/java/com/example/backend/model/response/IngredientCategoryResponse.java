package com.example.backend.model.response;

import lombok.Builder;

import java.math.BigInteger;

@Builder
public record IngredientCategoryResponse(BigInteger id, String name, Integer displayOrder) {
}
