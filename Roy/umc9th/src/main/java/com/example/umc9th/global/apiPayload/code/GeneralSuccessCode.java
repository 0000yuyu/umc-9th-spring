package com.example.umc9th.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseCode{
    SUCCESS_CODE(HttpStatus.ACCEPTED,"COMMON200","성공적으로 요청을 처리했습니다.");
    private final HttpStatus status;
    private final String code;
    private final String message;
}
