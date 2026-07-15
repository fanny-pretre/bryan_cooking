package com.example.backend.controller;

import com.example.backend.model.response.WeekResponse;
import com.example.backend.service.WeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/week")
public class WeekController {
    private final WeekService weekService;

    @GetMapping("/searchYear")
    public ResponseEntity<List<WeekResponse>> findWeeksByYearNumber(@RequestParam Integer numYear) {
        return ResponseEntity.ok(weekService.findWeeksByYearNumber(numYear));
    }

    @GetMapping("/searchMonthYear")
    public ResponseEntity<WeekResponse> findWeekByWeekNumberAndYearNumber(@RequestParam Integer numWeek, @RequestParam Integer numYear) {
        return ResponseEntity.ok(weekService.findWeekByWeekNumberAndYearNumber(numWeek, numYear));
    }
}
