package com.example.backend.repository;

import com.example.backend.model.entity.MealCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface MealCategoryRepository extends JpaRepository<MealCategoryEntity, BigInteger> {
}
