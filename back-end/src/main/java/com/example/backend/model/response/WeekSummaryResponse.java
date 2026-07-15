package com.example.backend.model.response;

import lombok.Builder;

import java.math.BigInteger;

@Builder
public record WeekSummaryResponse(
        BigInteger id,
        Integer numWeek,
        Integer numYear) {}