package com.example.backend.model.input;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.URL;

import java.math.BigInteger;
import java.util.List;

@Builder
    public record MealInputEdit(
        @NotNull
        String name,

        @URL
        @NotNull
        String imageUrl,

        @NotNull
        String season,

        @NotNull
        List<BigInteger> categoryIds,

        @NotNull
        List<BigInteger> ingredientIds

) {
    }
