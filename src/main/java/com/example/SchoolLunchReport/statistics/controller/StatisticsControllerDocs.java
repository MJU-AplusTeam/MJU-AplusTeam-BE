package com.example.SchoolLunchReport.statistics.controller;

import com.example.SchoolLunchReport.global.response.ApiResponse;
import com.example.SchoolLunchReport.statistics.domain.type.Period;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "순위 관련된 api")
public interface StatisticsControllerDocs {

    @Operation(summary = "인기, 비인기 5개 메뉴 조회 api")
    ApiResponse<?> getRankMenu(Period period);

    ApiResponse<?> getStatistics();
}
