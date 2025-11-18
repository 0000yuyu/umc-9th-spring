package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ReviewResDto {

    @Builder
    @Getter
    @AllArgsConstructor
    public static class ReviewItemDTO {
        Long id;
        int rate;
        String content;
        String storeName;
    }
}