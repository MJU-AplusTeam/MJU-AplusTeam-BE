package com.example.SchoolLunchReport.statistics.controller.dto.response;

import com.example.SchoolLunchReport.statistics.domain.entity.FoodRank;
import lombok.Builder;

@Builder
public record RankMenuResponseDto(
    Long id,
    String name,
    Double score,
    Integer rankChange,
    Integer rank
) {

    public static RankMenuResponseDto from(FoodRank foodRank) {
        return RankMenuResponseDto.builder()
            .id(foodRank.getFood().getId())
            .name(foodRank.getFood().getName())
            .score(foodRank.getScore())
            .rank(foodRank.getRanking())
            .rankChange(foodRank.getRankGap())
            .build();
    }
}
