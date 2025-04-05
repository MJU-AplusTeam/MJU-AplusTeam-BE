package com.example.SchoolLunchReport.statistics.controller.dto.response;

import java.util.List;
import lombok.Builder;

@Builder
public record RankMenuResponseDto(

    List<RankMenuResponse> topRankMenuResponse,
    List<RankMenuResponse> bottomRankMenuResponse

) {

    public static RankMenuResponseDto of(
        List<RankMenuResponse> topRankResponses,
        List<RankMenuResponse> bottomRankResponses
    ) {
        return RankMenuResponseDto.builder()
            .topRankMenuResponse(topRankResponses)
            .bottomRankMenuResponse(bottomRankResponses)
            .build();
    }
}
