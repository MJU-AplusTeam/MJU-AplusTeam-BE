package com.example.SchoolLunchReport.statistics.service;

import static com.example.SchoolLunchReport.statistics.domain.type.PeriodType.MONTHLY;
import static com.example.SchoolLunchReport.statistics.domain.type.PeriodType.WEEKLY;

import com.example.SchoolLunchReport.statistics.controller.dto.response.CombinedStatisticsResponse;
import com.example.SchoolLunchReport.statistics.controller.dto.response.RankMenuResponseDto;
import com.example.SchoolLunchReport.statistics.controller.dto.response.StatisticsResponse;
import com.example.SchoolLunchReport.statistics.domain.entity.FeedBack;
import com.example.SchoolLunchReport.statistics.domain.type.RankType;
import com.example.SchoolLunchReport.statistics.impl.FeedBackImpl;
import com.example.SchoolLunchReport.statistics.controller.dto.response.CombinedRankMenuResponseDto;
import com.example.SchoolLunchReport.statistics.domain.type.PeriodType;
import com.example.SchoolLunchReport.statistics.impl.RankImpl;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    final FeedBackImpl feedBackImpl;
    final RankImpl rankImpl;

    public CombinedRankMenuResponseDto getRankMenu(PeriodType periodType, LocalDate conditionDate) {
        List<RankMenuResponseDto> topRankMenuResponseDtos = rankImpl.generateRankResponse(
            periodType,
            conditionDate, RankType.TOP);
        List<RankMenuResponseDto> bottomRankMenuResponseDtos = rankImpl.generateRankResponse(
            periodType,
            conditionDate, RankType.BOTTOM);
        return CombinedRankMenuResponseDto.of(topRankMenuResponseDtos, bottomRankMenuResponseDtos);
    }


    public CombinedStatisticsResponse getStatistics() {
        List<FeedBack> feedBackListWeekly = feedBackImpl.getFeedBackBoundary(WEEKLY);
        List<FeedBack> feedBackListMonthly = feedBackImpl.getFeedBackBoundary(MONTHLY);

        StatisticsResponse statisticsResponseWeekly = rankImpl.produceStatistics(feedBackListWeekly,
            WEEKLY);
        StatisticsResponse statisticsResponseMonthly = rankImpl.produceStatistics(
            feedBackListMonthly,
            MONTHLY);
        return new CombinedStatisticsResponse(statisticsResponseWeekly, statisticsResponseMonthly);
    }

    public RankMenuResponseDto getTrendingMenu(PeriodType periodType) {
        List<FeedBack> feedBackList = feedBackImpl.getFeedBackBoundary(periodType);
        return rankImpl.getTrendingMenu(feedBackList, periodType);
    }
}
