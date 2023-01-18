package com.oneday.digest.core.http;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.oneday.digest.core.http.ApiResult.*;
import static org.assertj.core.api.Assertions.assertThat;

class ApiEntityTest {
    @Test
    void success_empty() {
        ApiEntity<String> success = ApiResult.success("");
        assertThat(success.toString()).isEqualTo("ApiEntity[success=true, response=, error=null]");
    }
    @Test
    void error() {
        ApiEntity<?> error = ApiResult.error(HttpStatus.BAD_REQUEST, "잘못된 매개변수입니다.");
        assertThat(error.toString()).isEqualTo("ApiEntity[success=false, response=, error=ApiError[status=400 BAD_REQUEST, message=잘못된 매개변수입니다.]]");
    }
}