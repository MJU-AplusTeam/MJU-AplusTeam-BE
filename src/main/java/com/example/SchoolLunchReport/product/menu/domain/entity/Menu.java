package com.example.SchoolLunchReport.product.menu.domain.entity;

import com.example.SchoolLunchReport.global.common.BaseTimeEntity;
import com.example.SchoolLunchReport.product.menu.domain.type.MealType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
public class Menu extends BaseTimeEntity {

    @Id
    private Long id;
    private MealType mealType;

}
