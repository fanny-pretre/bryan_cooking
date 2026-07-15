package com.example.backend.mapper.day;

import com.example.backend.mapper.week.WeekEntityToWeekSummaryResponseMapper;
import com.example.backend.model.entity.DayEntity;
import com.example.backend.model.response.DayResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DayEntityToDayResponseMapper {

    private WeekEntityToWeekSummaryResponseMapper weekEntityToWeekSummaryResponseMapper;

    public DayResponse dayEntityToDayResponseMapper(DayEntity dayEntity) {
        return DayResponse.builder()
                .id(dayEntity.getId())
                .date(dayEntity.getDate())
                .week(weekEntityToWeekSummaryResponseMapper.mapper(dayEntity.getWeek()))
                .build();
    }
}
