package com.example.backend.model.response;

import lombok.Builder;

import java.math.BigInteger;

    @Builder
    public record MealCategoryResponse(BigInteger id, String name) {}
