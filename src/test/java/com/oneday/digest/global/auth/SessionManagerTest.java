package com.oneday.digest.global.auth;

import com.oneday.digest.global.util.HttpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
class SessionManagerTest {

    @Test
    void sessionTest(){
        // 세션 생성
        MockHttpServletRequest request = new MockHttpServletRequest();
        HttpUtils.createSession(request, HttpUtils.SessionKey.LOGIN_MEMBER, "test");

        // 세션 확인
        HttpSession session = request.getSession(false);
        assertThat(session).isNotNull();
        assertThat(session.getAttribute(HttpUtils.SessionKey.LOGIN_MEMBER)).isEqualTo("test");

        // 세션 만료
        HttpUtils.expireSession(request);
        HttpSession expiredSession = request.getSession(false);
        assertThat(expiredSession).isNull();
    }
  
}