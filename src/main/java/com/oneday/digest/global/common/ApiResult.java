package com.oneday.digest.global.common;

import com.oneday.digest.global.error.ErrorResponse;
import com.oneday.digest.global.error.exception.ErrorCode;
import org.springframework.validation.BindingResult;

public class ApiResult {
    public static <T> ApiEntity<T> success(T response) {
        return new ApiEntity<>(true, response, null);
    }
    public static ApiEntity<?> error(ErrorResponse errorResponse) {
        return new ApiEntity<>(false, "", errorResponse);
    }

    public static ApiEntity<?> fail(BindingResult bindingResult) {
        return new ApiEntity<>(false, "", ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, bindingResult));
    }

    public record ApiEntity<T>(boolean isSuccess, T response, ErrorResponse errorResponse) {
    }
}