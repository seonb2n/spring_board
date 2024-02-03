package com.example.springboard.common.interceptor;

import com.example.springboard.common.annotations.CheckAuthByToken;
import com.example.springboard.common.exception.GlobalException;
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

    /**
     * 요청으로부터 검증을 해서, 회원 여부(isMember), 사용자 id(userId) 를 header 에 추가해준다.
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
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
                    int userId = authFacadeService.getUserByToken(token).getId();
                    request.setAttribute("userId", userId);
                } catch (GlobalException e) {
                    request.setAttribute("userId", null);
                }
            }
        }
        return true;
    }
}
