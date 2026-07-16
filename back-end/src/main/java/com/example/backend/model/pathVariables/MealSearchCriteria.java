package com.example.backend.model.pathVariables;

import lombok.Builder;

import java.math.BigInteger;
import java.util.List;

@Builder
public record MealSearchCriteria(
            String name,
            String season,
            List<BigInteger> categoryIds,
            List<BigInteger> ingredientIds
    ) {}

