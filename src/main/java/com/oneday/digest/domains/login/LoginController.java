package com.oneday.digest.domains.login;

import com.oneday.digest.core.http.ApiResult;
import com.oneday.digest.core.http.ApiResult.ApiEntity;
import com.oneday.digest.core.http.dto.ApiRequestDto;
import com.oneday.digest.domains.login.exception.AuthException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public ApiEntity<?> login(@RequestBody LoginRequestDto login) throws AuthException { return ApiResult.success(loginService.login(login.toServiceDto())); }
    
    public record LoginRequestDto(String username, String password) implements ApiRequestDto<LoginService.ServiceDto> {
        @Override
        public LoginService.ServiceDto toServiceDto() {
            return new LoginService.ServiceDto(username, password);
        }
    }
}
