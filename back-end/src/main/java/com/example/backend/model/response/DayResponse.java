package com.example.backend.model.response;

import lombok.Builder;

import java.math.BigInteger;
import java.util.Date;

@Builder
public record DayResponse(
        BigInteger id,
        Date date,
        WeekSummaryResponse week) {
}
