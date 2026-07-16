package com.example.backend.mapper.week;

import com.example.backend.mapper.day.DayResponseToDayEntityMapper;
import com.example.backend.model.entity.WeekEntity;
import com.example.backend.model.response.WeekResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class WeekResponseToWeekEntityMapper {
    private final DayResponseToDayEntityMapper dayResponseToDayEntityMapper;

    public WeekEntity mapper(WeekResponse weekResponse) {
    return WeekEntity.builder()
            .id(weekResponse.id())
            .numYear(weekResponse.numYear())
            .numWeek(weekResponse.numWeek())
            .days(weekResponse.days().stream()
                                .map(dayResponseToDayEntityMapper::mapper)
                                .toList())
            .build();
    }
}
