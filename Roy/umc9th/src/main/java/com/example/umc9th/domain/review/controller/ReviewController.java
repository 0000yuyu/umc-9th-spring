package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResDto;
import com.example.umc9th.domain.review.service.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ReviewController {

    private final ReviewQueryService reviewQueryService;
    public ReviewController(ReviewQueryService reviewQueryService)
    {
        this.reviewQueryService = reviewQueryService;
    }
    @GetMapping("reviews/search")
    public ApiResponse<List<ReviewResDto.ReviewItemDTO>> searchReview(@RequestParam String query, @RequestParam String type){
        List<ReviewResDto.ReviewItemDTO> reviewList = reviewQueryService.searchReview(query,type);
        GeneralSuccessCode code = GeneralSuccessCode.SUCCESS_CODE;
        return ApiResponse.onSuccess(code,reviewList);
    }
}
