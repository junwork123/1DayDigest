package com.oneday.digest.core.http;

import com.oneday.digest.core.entity.EntityBase;
import org.springframework.http.HttpStatus;

public class ApiEntity extends EntityBase {
    public static <T> ApiResult<T> success(T response) {
        return new ApiResult<>(true, response, null);
    }
    public static ApiResult error(HttpStatus status, String message) {
        return new ApiResult<>(false, "", new ApiError(status, message));
    }

    public record ApiError(HttpStatus status, String message) {
    }

    public record ApiResult<T>(boolean success, T response, ApiError error) {
    }
}