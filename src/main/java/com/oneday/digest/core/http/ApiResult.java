package com.oneday.digest.core.http;

import com.oneday.digest.core.entity.EntityBase;
import org.springframework.http.HttpStatus;

public class ApiResult extends EntityBase {
    public static <T> ApiEntity<T> success(T response) {
        return new ApiEntity<>(true, response, null);
    }
    public static ApiEntity<?> error(HttpStatus status, String message) {
        return new ApiEntity<>(false, "", new ApiError(status, message));
    }

    public record ApiError(HttpStatus status, String message) {
    }

    public record ApiEntity<T>(boolean success, T response, ApiError error) {
    }
}