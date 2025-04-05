package com.example.SchoolLunchReport.statistics.repository;

import com.example.SchoolLunchReport.product.food.domain.entity.Food;
import com.example.SchoolLunchReport.statistics.domain.entity.Rank;
import com.example.SchoolLunchReport.statistics.domain.type.PeriodType;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankJpaRepo extends JpaRepository<Rank, Long> {


    List<Rank> findTop5ByPeriodTypeAndStartPeriodOrderByRankAsc(PeriodType periodType,
        LocalDate conditionDate);

    List<Rank> findTop5ByPeriodTypeAndStartPeriodOrderByRankDesc(PeriodType periodType,
        LocalDate conditionDate);

    Rank findByFoodAndPeriodTypeAndStartPeriod(Food food, PeriodType periodType,
        LocalDate lastWeek);
}
