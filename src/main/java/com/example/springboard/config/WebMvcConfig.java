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

    /**
     * auth 관련 요청(토큰 발급) 및 회원 가입 관련 요청에 대해서는 인증을 처리하지 않음
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CheckAuthInterceptor(authFacadeService))
            .excludePathPatterns("/auth/**", "/users/join**");
    }

}
