package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface ReviewQueryDsl {
    List<ReviewResDto.ReviewItemDTO> searchReview(Predicate predicate);
}
