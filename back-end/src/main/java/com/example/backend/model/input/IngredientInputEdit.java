package com.example.backend.model.input;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.URL;

import java.math.BigInteger;

@Builder
    public record IngredientInputEdit(
        @NotNull
            String name,

        @URL
        @NotNull
        String image_url,

        @NotNull
        BigInteger category_id) {
    }
