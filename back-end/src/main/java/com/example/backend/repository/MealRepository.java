package com.example.backend.repository;

import com.example.backend.model.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, BigInteger> {
}