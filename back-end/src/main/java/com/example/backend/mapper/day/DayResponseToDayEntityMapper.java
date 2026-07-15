package com.example.backend.mapper.day;

import com.example.backend.mapper.week.WeekSummaryResponseToWeekEntityMapper;
import com.example.backend.model.entity.DayEntity;
import com.example.backend.model.response.DayResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DayResponseToDayEntityMapper {

    private WeekSummaryResponseToWeekEntityMapper weekSummaryResponseToWeekEntityMapper;

    public DayEntity mapper(DayResponse dayResponse) {
        return DayEntity.builder()
                .id(dayResponse.id()).
                date(dayResponse.date())
                .week(weekSummaryResponseToWeekEntityMapper.mapper(dayResponse.week()))
                .build();
    }
}
