package com.example.backend.mapper.mealDay;

import com.example.backend.mapper.day.DayEntityToDayResponseMapper;
import com.example.backend.mapper.meal.MealEntityToMealResponseMapper;
import com.example.backend.model.entity.MealDayEntity;
import com.example.backend.model.response.MealDayResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MealDayEntityToMealDayResponseMapper {

    private MealEntityToMealResponseMapper mealEntityToMealResponseMapper;
    private DayEntityToDayResponseMapper dayEntityToDayResponseMapper;

    public MealDayResponse mapper(MealDayEntity mealDayEntity) {

        return MealDayResponse.builder()
                .id(mealDayEntity.getId())
                .mealTime(mealDayEntity.getMealTime())
                .day(dayEntityToDayResponseMapper.dayEntityToDayResponseMapper(mealDayEntity.getDay()))
                .meal(mealEntityToMealResponseMapper.mealMapper(mealDayEntity.getMeal()))
                .build();
    }
}
