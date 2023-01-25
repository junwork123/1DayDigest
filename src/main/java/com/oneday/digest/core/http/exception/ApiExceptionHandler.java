package com.oneday.digest.core.http.exception;

import com.oneday.digest.core.http.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static com.oneday.digest.core.http.ApiResult.*;
@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ApiException.class)
    public ApiEntity<?> handleCustomException(ApiException e) {
        log.warn("RestApiException", e);
        return ApiResult.error(HttpStatus.FORBIDDEN, e.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiEntity<?> handleIllegalArgument(IllegalArgumentException e) {
        log.warn("handleIllegalArgument", e);
        return ApiResult.error(HttpStatus.BAD_REQUEST, e.getMessage());
    }
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler({Exception.class})
    public ApiEntity<?> handleAllException(Exception e) {
        log.warn("handleAllException", e);
        return ApiResult.error(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
    }
}
