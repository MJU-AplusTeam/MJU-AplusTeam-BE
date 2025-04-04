package com.example.SchoolLunchReport.statistics.impl;

import com.example.SchoolLunchReport.statistics.domain.entity.FeedBack;
import com.example.SchoolLunchReport.statistics.repository.FeedBackJpaRepo;
import com.example.SchoolLunchReport.statistics.domain.type.PeriodType;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedBackImpl {

    final FeedBackJpaRepo feedBackJpaRepo;

    public List<FeedBack> getFeedBackBoundary(PeriodType periodType) {
        LocalDate conditionDate = PeriodType.getConditionDate(periodType);
        return feedBackJpaRepo.findByCreatedAtAfter(conditionDate);
    }
}
