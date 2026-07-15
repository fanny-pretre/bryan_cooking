package com.example.backend.service;

import com.example.backend.exception.DataNotFound;
import com.example.backend.mapper.week.WeekEntityToWeekResponseMapper;
import com.example.backend.model.entity.WeekEntity;
import com.example.backend.model.response.WeekResponse;
import com.example.backend.repository.WeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeekService {

    private final WeekRepository weekRepository;

    private final WeekEntityToWeekResponseMapper weekEntityToWeekResponseMapper;

    public List<WeekResponse> findWeeksByYearNumber(Integer numYear) {
        List<WeekEntity> weeks = weekRepository.findByNumYearOrderByNumWeek(numYear);

        return weeks.stream()
                .map(weekEntityToWeekResponseMapper::weekEntityToWeekResponse)
                .toList();
    }

    public WeekResponse findWeekByWeekNumberAndYearNumber(Integer numWeek, Integer numYear) {
        WeekEntity week = weekRepository.findByNumWeekAndNumYear(numWeek, numYear)
                .orElseThrow(() -> new DataNotFound(
                        "week",
                        String.format("semaine %d / année %d", numWeek, numYear)
                ));

        return weekEntityToWeekResponseMapper.weekEntityToWeekResponse(week);
    }

}
