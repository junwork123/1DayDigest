package com.oneday.digest.core.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static com.oneday.digest.core.http.ApiResult.*;
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler({ RuntimeException.class })
    public ApiEntity<?> BadRequestException(final RuntimeException ex) {
        return ApiResult.error(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
