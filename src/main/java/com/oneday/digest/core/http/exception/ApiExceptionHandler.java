package com.oneday.digest.core.http.exception;

import com.oneday.digest.core.http.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static com.oneday.digest.core.http.ApiResult.*;
@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ApiEntity<?> handleCustomException(ApiException e) {
        log.warn("RestApiException", e);
        return ApiResult.error(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ApiEntity<?> handleIllegalArgument(IllegalArgumentException e) {
        log.warn("handleIllegalArgument", e);
        return ApiResult.error(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ApiEntity<?> handleAllException(Exception e) {
        log.warn("handleAllException", e);
        return ApiResult.error(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
    }
}
