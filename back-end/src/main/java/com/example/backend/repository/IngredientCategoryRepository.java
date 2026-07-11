package com.example.backend.repository;

import com.example.backend.model.entity.IngredientCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategoryEntity, BigInteger> {
}
