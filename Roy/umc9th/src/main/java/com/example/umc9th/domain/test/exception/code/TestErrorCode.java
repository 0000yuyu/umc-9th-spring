package com.example.umc9th.domain.test.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum TestErrorCode implements BaseCode {
    TEST_EXCEPTION(HttpStatus.FORBIDDEN,"TEST400_1","이거는 테스트"),;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
