package com.example.backend.model.input;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.URL;

import java.math.BigInteger;

@Builder
    public record IngredientInput(
        @NotNull
        String name,

        @URL
        @NotNull
        String imageUrl,

        @NotNull
        BigInteger categoryId) {
    }
