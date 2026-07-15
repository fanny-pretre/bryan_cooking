package com.example.backend.repository;

import com.example.backend.model.entity.WeekEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface WeekRepository extends JpaRepository<WeekEntity, BigInteger> {
    @EntityGraph(attributePaths = "days")
    List<WeekEntity> findByNumYearOrderByNumWeek(Integer numYear);

    @EntityGraph(attributePaths = "days")
    Optional<WeekEntity> findByNumWeekAndNumYear(Integer numWeek, Integer numYear);
}
