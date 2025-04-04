package com.example.SchoolLunchReport.product.menu.domain.entity;

import com.example.SchoolLunchReport.global.common.BaseTimeEntity;
import com.example.SchoolLunchReport.product.menu.domain.type.MealType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;

@Entity
@Getter
public class Menu {

    @Id
    private Long id;
    private LocalDate date;
    private MealType mealType;
    private String evaluation;
}
