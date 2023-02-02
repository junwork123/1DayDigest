package com.oneday.digest.domain.login.api;

import com.oneday.digest.domain.login.application.LoginService;
import com.oneday.digest.domain.login.dto.LoginRequest;
import com.oneday.digest.domain.member.domain.Member;
import com.oneday.digest.global.common.ApiResult;
import com.oneday.digest.global.util.HttpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.oneday.digest.global.common.ApiResult.ApiEntity;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginApi {
    private final LoginService loginService;
    @PostMapping("/login")
    public ApiEntity<?> login(@Valid @ModelAttribute LoginRequest loginRequest, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return ApiResult.fail(bindingResult);
        }
        Member loginMember = loginService.login(loginRequest.loginId(), loginRequest.password());
        HttpUtils.createSession(request, HttpUtils.SessionKey.LOGIN_MEMBER, loginMember);
        return ApiResult.success(loginMember);
    }
    @PostMapping("/logout")
    public ApiEntity<?> logout(HttpServletRequest request){
        HttpUtils.expireSession(request);
        return ApiResult.success(HttpStatus.NO_CONTENT);
    }
//    @GetMapping("/")
//    public String homeLogin(@SessionAttribute(name = "", required = false) Member loginMember, Model model) {
//        //세션에 회원 데이터가 없으면 home
//        if (loginMember == null) {
//            return "home";
//        }
//        //세션이 유지되면 로그인으로 이동
//        model.addAttribute("member", loginMember);
//        return "loginHome";
//    }
}


