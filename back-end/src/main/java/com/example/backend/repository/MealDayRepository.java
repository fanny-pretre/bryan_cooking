package com.example.backend.repository;

import com.example.backend.model.entity.MealDayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface MealDayRepository extends JpaRepository<MealDayEntity, BigInteger> {
}
