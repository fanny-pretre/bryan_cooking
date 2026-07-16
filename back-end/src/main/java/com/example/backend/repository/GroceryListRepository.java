package com.example.backend.repository;

import com.example.backend.model.entity.GroceryListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface GroceryListRepository extends JpaRepository<GroceryListEntity, BigInteger> {

    @Query("SELECT DISTINCT gl FROM GroceryListEntity gl LEFT JOIN FETCH gl.items")
    List<GroceryListEntity> findAllWithItems();
}
