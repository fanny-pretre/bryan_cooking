package com.example.backend.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record MealCategoryInput(

        @NotNull
        String name
) {
}
