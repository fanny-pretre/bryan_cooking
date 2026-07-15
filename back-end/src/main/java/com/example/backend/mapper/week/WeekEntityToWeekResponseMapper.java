package com.example.backend.mapper.week;

import com.example.backend.mapper.day.DayEntityToDayResponseMapper;
import com.example.backend.model.entity.WeekEntity;
import com.example.backend.model.response.WeekResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WeekEntityToWeekResponseMapper {

    private final DayEntityToDayResponseMapper dayEntityToDayResponseMapper;

    public WeekResponse weekEntityToWeekResponse(WeekEntity weekEntity) {
        return WeekResponse.builder()
                .id(weekEntity.getId())
                .numWeek(weekEntity.getNumWeek())
                .numYear(weekEntity.getNumYear())
                .days(weekEntity.getDays().stream()
                        .map(dayEntityToDayResponseMapper::dayEntityToDayResponseMapper)
                        .toList())
                .build();
    }
}
