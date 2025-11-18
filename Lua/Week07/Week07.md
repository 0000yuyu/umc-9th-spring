## GeneralSuccessCode.java
```java
package com.example.umc9th.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum GeneralSuccessCode implements BaseSuccessCode{

    OK(HttpStatus.OK,
            "COMMON200_1",
            "성공입니다."),

    CREATED(HttpStatus.CREATED,
            "COMMON201_1",
            "요청 성공입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

```

## ApiResponse의 onSuccess 메서드
```java
// 성공한 경우 (result 포함)
    public static <T> ApiResponse<T> onSuccess(BaseSuccessCode code, T result){
        return new ApiResponse<>(true, code.getCode(), code.getMessage(),result);
    }
```
