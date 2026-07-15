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
@Table(name="WEEK")
public class WeekEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @NotNull
    private Integer numYear;

    @NotNull
    private Integer numWeek;

    @OneToMany(mappedBy = "week", fetch = FetchType.LAZY)
    private List<DayEntity> days = new ArrayList<>();
}
