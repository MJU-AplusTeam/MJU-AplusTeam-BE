package com.example.SchoolLunchReport.statistics.domain.type;

import java.time.LocalDate;

public enum PeriodType {
    WEEKLY, MONTHLY;
    private final static int PERIOD_BOUNDARY = 1;

    public static LocalDate getConditionDate(PeriodType periodType) {
        LocalDate today = LocalDate.now();
        return switch (periodType) {
            case WEEKLY -> today.minusWeeks(PERIOD_BOUNDARY);
            case MONTHLY -> today.minusMonths(PERIOD_BOUNDARY);
        };
    }
}
