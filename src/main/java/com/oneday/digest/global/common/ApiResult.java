package com.oneday.digest.global.common;

import com.oneday.digest.global.error.ErrorResponse;

public class ApiResult {
    public static <T> ApiEntity<T> success(T response) {
        return new ApiEntity<>(true, response, null);
    }
    public static ApiEntity<?> error(ErrorResponse errorResponse) {
        return new ApiEntity<>(false, "", errorResponse);
    }

    public record ApiEntity<T>(boolean isSuccess, T response, ErrorResponse errorResponse) {
    }
}