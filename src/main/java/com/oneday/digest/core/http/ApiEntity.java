package com.oneday.digest.core.http;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

public class ApiEntity {
    public static <T> ApiResult<T> success(T response) {
        return new ApiResult<>(true, response, null);
    }
    public static ApiResult<?> error(HttpStatus status, String message) {
        return new ApiResult<>(false, null, new ApiError(status, message));
    }

    public record ApiError(HttpStatus status, String message) {
        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        }
    }

    public record ApiResult<T>(boolean success, T response, ApiError error) {
        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        }
    }
}