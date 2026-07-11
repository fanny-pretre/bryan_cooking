package com.example.backend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="INGREDIENT")
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @NotNull
    private String name;

    @URL
    private String image_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_category_id", nullable = false)
    private IngredientCategoryEntity ingredientCategory;
}
