package com.oneday.digest.global.error;

import com.oneday.digest.global.error.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BusinessException extends RuntimeException {
    private ErrorCode errorCode;
}
