package com.example.backend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="INGREDIENT_CATEGORY")
public class IngredientCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @NotNull
    private String name;

    @NotNull
    private Integer display_order;

    @OneToMany(mappedBy = "ingredientCategory", fetch = FetchType.LAZY)
    private List<IngredientEntity> ingredients = new ArrayList<>();
}
