package com.oneday.digest.core.http;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class ApiEntityTest {
    @Test
    void success_empty() {
        ApiEntity.ApiResult<String> success = ApiEntity.success("");
        assertThat(success.toString()).isEqualTo("{\"success\":true,\"response\":\"\",\"error\":null}");
    }
    @Test
    void error() {
        ApiEntity.ApiResult<?> error = ApiEntity.error(HttpStatus.BAD_REQUEST, "잘못된 매개변수입니다.");
        assertThat(error.toString()).isEqualTo("{\"success\":false,\"response\":null,\"error\":{\"status\":400 BAD_REQUEST,\"message\":\"잘못된 매개변수입니다.\"}}");
    }
}