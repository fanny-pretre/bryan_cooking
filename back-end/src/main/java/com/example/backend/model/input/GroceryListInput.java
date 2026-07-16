package com.example.backend.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigInteger;

@Builder
public record GroceryListInput(
        @NotNull
        BigInteger weekId
) {
}
