package com.example.backend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="MEAL")
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @NotNull
    private String name;

    @URL
    private String image_url;

    @NotNull
    private String season;

    @ManyToMany
    @JoinTable(
            name = "MEAL_CATEGORY_LINK",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_category_id")
    )

    private List<MealCategoryEntity> mealCategories = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "MEAL_INGREDIENT_LINK",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<IngredientEntity> ingredients = new ArrayList<>();
}
