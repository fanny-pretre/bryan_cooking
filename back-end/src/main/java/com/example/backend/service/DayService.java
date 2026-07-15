package com.example.backend.service;

import com.example.backend.exception.DataNotFound;
import com.example.backend.mapper.day.DayEntityToDayResponseMapper;
import com.example.backend.model.entity.DayEntity;
import com.example.backend.model.response.DayResponse;
import com.example.backend.repository.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class DayService {
    private final DayRepository dayRepository;

    private final DayEntityToDayResponseMapper dayEntityToDayResponseMapper;

    public DayResponse findDayById(String id) {

        DayEntity day = dayRepository.findById(new BigInteger(id))
                .orElseThrow(() ->
                        new DataNotFound("day", id));

        return dayEntityToDayResponseMapper.dayEntityToDayResponseMapper(day);
    }
}
