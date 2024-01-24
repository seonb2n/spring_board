package com.example.springboard.common.interceptor;

import com.example.springboard.common.annotations.CheckAuthByToken;
import com.example.springboard.common.exception.user.UserNotFoundByUserIdException;
import com.example.springboard.service.AuthFacadeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class CheckAuthInterceptor implements HandlerInterceptor {

    private final AuthFacadeService authFacadeService;

    public CheckAuthInterceptor(AuthFacadeService authFacadeService) {
        this.authFacadeService = authFacadeService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            CheckAuthByToken annotation = (CheckAuthByToken) handlerMethod.getMethod()
                .getAnnotation(CheckAuthByToken.class);

            if (annotation != null) {
                String token = request.getHeader("Authorization");
                if (token == null) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        "Authentication failed");
                    return false;
                }
                boolean isMember = authFacadeService.isTokenOwnedByMember(token);
                request.setAttribute("isMember", isMember);
                try {
                    int userId = authFacadeService.getUserByToken(token).getRegisteredUserId();
                    request.setAttribute("userId", userId);
                } catch (UserNotFoundByUserIdException e) {
                    request.setAttribute("userId", null);
                }
            }
        }
        return true;
    }
}
