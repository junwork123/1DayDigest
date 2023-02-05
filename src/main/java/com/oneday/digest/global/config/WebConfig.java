package com.oneday.digest.global.config;

import com.oneday.digest.global.auth.argumentresolver.LoginMemberArgumentResolver;
import com.oneday.digest.global.config.interceptor.LogInterceptor;
import com.oneday.digest.global.config.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final String[] EXCLUDE_PATHS = { "/css/**", "/js/**", "/img/**", "/lib/**", "/*.ico", "/error" };
    private static final String[] LOGIN_WHITE_LIST = {"/", "/members/add", "/login", "/logout","/css/*"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATHS);

        registry.addInterceptor(new LoginInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns(LOGIN_WHITE_LIST);

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginMemberArgumentResolver());
    }
}
