package com.example.SchoolLunchReport.statistics.controller.dto.response;

import com.example.SchoolLunchReport.statistics.domain.type.Period;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record StatisticsResponse(
    Period period,
    List<ScoreCount> scores
) {

    @AllArgsConstructor
    public static class ScoreCount {

        private int score;
        private long count;

    }
}
