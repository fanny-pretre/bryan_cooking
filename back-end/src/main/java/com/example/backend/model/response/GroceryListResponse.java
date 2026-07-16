package com.example.backend.model.response;

import lombok.Builder;

import java.math.BigInteger;
import java.util.List;

@Builder
public record GroceryListResponse(
        BigInteger id,
        WeekResponse week,
        List<GroceryItemResponse> items
) {}