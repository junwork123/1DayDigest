package com.oneday.digest.domain.login.api;

import com.oneday.digest.domain.login.application.LoginService;
import com.oneday.digest.domain.login.dto.LoginRequest;
import com.oneday.digest.global.common.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.oneday.digest.global.common.ApiResult.ApiEntity;

@Slf4j
@RestController("/login")
@RequiredArgsConstructor
public class LoginApi {
    private final LoginService loginService;
    @PostMapping
    public ApiEntity<?> login(@Valid @ModelAttribute LoginRequest loginRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ApiResult.fail(bindingResult);
        }
        return ApiResult.success(loginService.login(loginRequest.loginId(), loginRequest.password()));
    }
}


