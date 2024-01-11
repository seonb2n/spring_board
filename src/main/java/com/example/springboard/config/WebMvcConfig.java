package com.example.springboard.config;

import com.example.springboard.common.interceptor.CheckAuthInterceptor;
import com.example.springboard.service.AuthFacadeService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final AuthFacadeService authFacadeService;

    public WebMvcConfig(AuthFacadeService authFacadeService) {
        this.authFacadeService = authFacadeService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CheckAuthInterceptor(authFacadeService));
    }

}
