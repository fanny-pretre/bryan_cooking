package com.example.backend.model.response;


import lombok.Builder;

import java.math.BigInteger;

@Builder
public record IngredientResponse(BigInteger id, String name, String image_url, IngredientCategoryResponse category) {
}
