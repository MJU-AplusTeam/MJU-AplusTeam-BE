package com.example.SchoolLunchReport.statistics.service;

import static com.example.SchoolLunchReport.statistics.domain.type.Period.MONTHLY;
import static com.example.SchoolLunchReport.statistics.domain.type.Period.WEEKLY;

import com.example.SchoolLunchReport.statistics.controller.dto.response.CombinedStatisticsResponse;
import com.example.SchoolLunchReport.statistics.controller.dto.response.StatisticsResponse;
import com.example.SchoolLunchReport.statistics.domain.entity.FeedBack;
import com.example.SchoolLunchReport.statistics.impl.FeedBackImpl;
import com.example.SchoolLunchReport.statistics.controller.dto.response.RankMenuResponseDto;
import com.example.SchoolLunchReport.statistics.domain.type.Period;
import com.example.SchoolLunchReport.statistics.impl.RankImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    final FeedBackImpl feedBackImpl;
    final RankImpl rankImpl;

    public RankMenuResponseDto getRankMenu(Period period) {
        List<FeedBack> feedBackList = feedBackImpl.getFeedBackBoundary(period);

        return rankImpl.generateRankResponses(feedBackList, 5);
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
}
