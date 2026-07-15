package com.example.backend.service;

import com.example.backend.exception.DataNotFound;
import com.example.backend.mapper.day.DayResponseToDayEntityMapper;
import com.example.backend.mapper.meal.MealResponseToMealEntityMapper;
import com.example.backend.mapper.mealDay.MealDayEntityToMealDayResponseMapper;
import com.example.backend.model.entity.MealDayEntity;
import com.example.backend.model.input.MealDayInput;
import com.example.backend.model.input.MealDayInputEdit;
import com.example.backend.model.response.DayResponse;
import com.example.backend.model.response.MealDayResponse;
import com.example.backend.model.response.MealResponse;
import com.example.backend.repository.MealDayRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealDayService {
    private final MealDayRepository mealDayRepository;

    private final MealDayEntityToMealDayResponseMapper mealDayEntityToMealDayResponseMapper;
    private final DayService dayService;
    private final MealService mealService;
    private final DayResponseToDayEntityMapper dayResponseToDayEntityMapper;
    private final MealResponseToMealEntityMapper mealResponseToMealEntityMapper;

    public List<MealDayResponse> getAllMealDays() {

        List<MealDayEntity> mealDays = mealDayRepository.findAll();

        return mealDays.stream()
                .map(mealDayEntityToMealDayResponseMapper::mapper)
                .toList();
    }

    public MealDayResponse findMealDayById(BigInteger id) {
        MealDayEntity mealDay = mealDayRepository.findById(id)
                .orElseThrow(() ->
                       new DataNotFound("mealDay", id));

       return mealDayEntityToMealDayResponseMapper.mapper(mealDay);
    }

    public MealDayResponse createMealDay(@Valid MealDayInput mealDayInput) {
        DayResponse day = dayService.findDayById(mealDayInput.dayId());
        MealResponse meal = mealService.findMealById(mealDayInput.mealId());

        MealDayEntity savedEntity = mealDayRepository.save(
                MealDayEntity.builder()
                        .day(dayResponseToDayEntityMapper.mapper(day))
                        .meal(mealResponseToMealEntityMapper.mapper(meal))
                        .mealTime(mealDayInput.mealTime())
                        .build()
        );

        return mealDayEntityToMealDayResponseMapper.mapper(savedEntity);
    }

    public MealDayResponse editMealDay(MealDayInputEdit mealDayInputEdit, BigInteger id) {

        findMealDayById(id);
        DayResponse day = dayService.findDayById(mealDayInputEdit.dayId());
        MealResponse meal = mealService.findMealById(mealDayInputEdit.mealId());

        MealDayEntity updatedEntity = mealDayRepository.save(
                MealDayEntity.builder()
                        .id(id)
                        .day(dayResponseToDayEntityMapper.mapper(day))
                        .meal(mealResponseToMealEntityMapper.mapper(meal))
                        .mealTime(mealDayInputEdit.mealTime())
                        .build()
        );

        return mealDayEntityToMealDayResponseMapper.mapper(updatedEntity);
    }

    public void deleteMealDay(BigInteger id) {
        MealDayEntity entite = mealDayRepository.findById(id)
                .orElseThrow(() ->
                        new DataNotFound("meal", id));

        mealDayRepository.delete(entite);
    }
}
