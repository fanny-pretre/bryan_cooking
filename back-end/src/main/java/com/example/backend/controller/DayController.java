package com.example.backend.controller;

import com.example.backend.model.response.DayResponse;
import com.example.backend.service.DayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/day")
public class DayController {
    private final DayService dayService;

    @GetMapping("/{id}")
    public ResponseEntity<DayResponse> findDayById(@PathVariable String id) {
        return ResponseEntity.ok(dayService.findDayById(new BigInteger(id)));
    }
}
