package com.example.SchoolLunchReport.product.food.repository;

import com.example.SchoolLunchReport.product.food.domain.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodJpaRepository extends JpaRepository<Food, Long> {

}
