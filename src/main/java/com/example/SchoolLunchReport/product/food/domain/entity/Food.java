package com.example.SchoolLunchReport.product.food.domain.entity;

import com.example.SchoolLunchReport.product.food.domain.type.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Food {

    @Id
    private Long id;
    private String foodName;
    private Category category;
    private Integer foodRank;

    @Builder
    public Food(Long id, String foodName, Category category, Integer foodRank) {
        this.id = id;
        this.foodName = foodName;
        this.category = category;
        this.foodRank = foodRank;
    }
}
