package com.example.backend.model.entity;

import com.example.backend.model.enums.MealTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "MEAL_DAY_LINK", uniqueConstraints = @UniqueConstraint(columnNames = {"dayId", "mealTime"})
)
public class MealDayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dayId", nullable = false)
    private DayEntity day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mealId", nullable = false)
    private MealEntity meal;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "mealTime")
    private MealTime mealTime;
}