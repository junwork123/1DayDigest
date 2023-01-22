package com.oneday.digest.domains.login;

import com.oneday.digest.domains.login.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService {
    public String login(ServiceDto login) throws AuthException {
        log.info(login.username() + " " + login.password());
        if (!login.username().equals("user") || !login.password().equals("password")) {
            throw new AuthException("Invalid username or password");
        }
        return "Login successful";
    }

    protected record ServiceDto(String username, String password) {
    }
    protected record ResponseDto(String username, String password) {
    }
}
