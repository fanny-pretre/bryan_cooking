package com.example.backend.mapper.week;

import com.example.backend.model.entity.WeekEntity;
import com.example.backend.model.response.WeekSummaryResponse;
import org.springframework.stereotype.Component;

@Component
public class WeekEntityToWeekSummaryResponseMapper {

    public WeekSummaryResponse mapper(WeekEntity weekEntity) {
        return WeekSummaryResponse.builder()
                .id(weekEntity.getId())
                .numWeek(weekEntity.getNumWeek())
                .numYear(weekEntity.getNumYear())
                .build();
    }
}