package com.oneday.digest.domains.login;

import com.oneday.digest.core.http.ApiResult;
import com.oneday.digest.core.http.ApiResult.*;
import com.oneday.digest.domains.login.exception.AuthException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public ApiEntity<?> login(@RequestBody LoginDto login) throws AuthException { return ApiResult.success(loginService.login(login)); }

    @Builder
    @Getter
    @ToString
    public static class LoginDto {
        private final String username;
        private final String password;
    }
}
