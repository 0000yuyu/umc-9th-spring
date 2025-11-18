package com.example.umc9th.domain.test.exception;

import com.example.umc9th.global.apiPayload.code.BaseCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

public class TestException extends GeneralException {
    public TestException(BaseCode code) {
        super(code);
    }
}
