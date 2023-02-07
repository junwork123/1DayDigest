package com.oneday.digest.global.error.deprecated;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//@Component
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error-page/404");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-page/500");
        ErrorPage errorRuntimeExceptionPage = new ErrorPage(RuntimeException.class, "/error-page/500");
        factory.addErrorPages(error404Page, error500Page, errorRuntimeExceptionPage);
    }
}
