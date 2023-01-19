package com.oneday.digest.domains.login;

import com.oneday.digest.domains.login.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginService {
    public String login(LoginController.LoginDto login) throws AuthException {
        log.info(login.getUsername() + " " + login.getPassword());
        if (!login.getUsername().equals("user") || !login.getPassword().equals("password")) {
            throw new AuthException("Invalid username or password");
        }
        return "Login successful";
    }
}
