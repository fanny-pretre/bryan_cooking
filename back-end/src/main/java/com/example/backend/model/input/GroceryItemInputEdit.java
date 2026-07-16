package com.example.backend.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigInteger;

@Builder
public record GroceryItemInputEdit(
        @NotNull
        BigInteger ingredientId,

        @NotNull
        BigInteger groceryListId,

        String customLabel,

        @NotNull
        Integer quantity,

        Boolean checked
) {
}
