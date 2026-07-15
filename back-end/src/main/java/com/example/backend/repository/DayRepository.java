package com.example.backend.repository;

import com.example.backend.model.entity.DayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface DayRepository extends JpaRepository<DayEntity, BigInteger> {
}
