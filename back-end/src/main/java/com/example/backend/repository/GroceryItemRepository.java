package com.example.backend.repository;

import com.example.backend.model.entity.GroceryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface GroceryItemRepository extends JpaRepository<GroceryItemEntity, BigInteger> {
}
