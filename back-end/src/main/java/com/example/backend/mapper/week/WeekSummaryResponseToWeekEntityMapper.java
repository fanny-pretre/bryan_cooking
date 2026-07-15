package com.example.backend.mapper.week;

import com.example.backend.model.entity.WeekEntity;
import com.example.backend.model.response.WeekSummaryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WeekSummaryResponseToWeekEntityMapper {

    public WeekEntity mapper(WeekSummaryResponse weekSummaryResponse) {
        return WeekEntity.builder()
                .id(weekSummaryResponse.id())
                .numYear(weekSummaryResponse.numYear())
                .numWeek(weekSummaryResponse.numWeek())
                .build();
    }
}
