package com.example.backend.model.response;

import com.example.backend.model.enums.MealTime;
import lombok.Builder;

import java.math.BigInteger;

@Builder
public record MealDayResponse(
        BigInteger id,
        MealTime mealTime,
        DayResponse day,
        MealResponse meal) {}