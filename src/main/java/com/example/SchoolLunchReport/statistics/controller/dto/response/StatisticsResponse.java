package com.example.SchoolLunchReport.statistics.controller.dto.response;

import com.example.SchoolLunchReport.statistics.domain.type.PeriodType;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record StatisticsResponse(
    PeriodType periodType,
    List<ScoreCount> scores
) {

    @AllArgsConstructor
    public static class ScoreCount {

        private int score;
        private long count;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof ScoreCount)) {
                return false;
            }
            return this.score == ((ScoreCount) o).score && this.count == ((ScoreCount) o).count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(score, count);
        }
    }
}
