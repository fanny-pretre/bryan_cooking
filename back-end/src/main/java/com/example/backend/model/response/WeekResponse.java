package com.example.backend.model.response;

import lombok.Builder;

import java.math.BigInteger;
import java.util.List;

@Builder
public record WeekResponse(
        BigInteger id,
        Integer numWeek,
        Integer numYear,
        List<DayResponse> days) {
}
