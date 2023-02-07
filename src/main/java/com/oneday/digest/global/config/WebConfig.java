package com.oneday.digest.global.config;

import com.oneday.digest.global.auth.argumentresolver.LoginMemberArgumentResolver;
import com.oneday.digest.global.config.interceptor.AuthInterceptor;
import com.oneday.digest.global.config.interceptor.LogInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private static final String[] DEFAULT_EXCLUDE_PATHS = { "/css/**", "/js/**", "/img/**", "/lib/**", "/*.ico",};
    private static final String[] ERROR_PATHS = { "/error", "/error-page/**" };
    private static final String[] LOGIN_WHITE_LIST = {"/", "/members/add", "/login", "/logout","/css/*"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(DEFAULT_EXCLUDE_PATHS);

        registry.addInterceptor(new AuthInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns(combinePath(DEFAULT_EXCLUDE_PATHS, ERROR_PATHS, LOGIN_WHITE_LIST));
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginMemberArgumentResolver());
    }

    private List<String> combinePath(String[]... paths) {
        List<String> result = Arrays.stream(paths)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        log.info("combinePath: {}", result);
        return result;
    }
}
