package com.example.backend.repository.specification;

import com.example.backend.model.entity.IngredientEntity;
import com.example.backend.model.entity.MealCategoryEntity;
import com.example.backend.model.entity.MealEntity;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigInteger;
import java.util.List;

public class MealSpecification {

    public static Specification<MealEntity> hasName(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isBlank()) {
                return cb.conjunction(); // pas de filtre
            }
            return cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
        };
    }

    public static Specification<MealEntity> hasSeason(String season) {
        return (root, query, cb) -> {
            if (season == null || season.isBlank()) {
                return cb.conjunction();
            }
            return cb.equal(root.get("season"), season);
        };
    }

    public static Specification<MealEntity> hasCategoryIds(List<BigInteger> categoryIds) {
        return (root, query, cb) -> {
            if (categoryIds == null || categoryIds.isEmpty()) {
                return cb.conjunction();
            }
            query.distinct(true);
            Join<MealEntity, MealCategoryEntity> join = root.join("categories");
            return join.get("id").in(categoryIds);
        };
    }

    public static Specification<MealEntity> hasIngredientIds(List<BigInteger> ingredientIds) {
        return (root, query, cb) -> {
            if (ingredientIds == null || ingredientIds.isEmpty()) {
                return cb.conjunction();
            }
            query.distinct(true);
            Join<MealEntity, IngredientEntity> join = root.join("ingredients");
            return join.get("id").in(ingredientIds);
        };
    }
}