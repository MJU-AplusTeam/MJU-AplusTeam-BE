package com.example.SchoolLunchReport.statistics.controller.dto.response;

import com.example.SchoolLunchReport.product.food.domain.entity.Food;
import com.example.SchoolLunchReport.statistics.domain.entity.Rank;
import lombok.Builder;

@Builder
public record RankMenuResponseDto(
    Long id,
    String name,
    Double score,
    Integer rankChange,
    Integer rank
) {

    public static RankMenuResponseDto from(Rank rank) {
        return RankMenuResponseDto.builder()
            .id(rank.getFood().getId())
            .name(rank.getFood().getName())
            .score(rank.getScore())
            .rank(rank.getRank())
            .rankChange(rank.getRankGap())
            .build();
    }
}
