package com.example.backend.model.input;


import com.example.backend.model.enums.MealTime;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record MealDayInputEdit(
        @NotNull
        BigInteger mealId,

        @NotNull
        BigInteger dayId,

        @NotNull
        MealTime mealTime
) {
    }
