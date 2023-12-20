package com.example.springboard.common;

import com.example.springboard.common.handler.GlobalExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ControllerLogAdvisor {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private String paramMapToString(Map<String, String[]> paramMap) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(": [");
            String[] values = entry.getValue();
            if (values != null && values.length > 0) {
                stringBuilder.append(String.join(", ", values));
            }
            stringBuilder.append("]\n");
        }

        return stringBuilder.toString();
    }

    @Pointcut("execution(* com.example.springboard..*Controller.*(..))")
    private void onRequest() {
    }

    @Around("com.example.springboard.common.ControllerLogAdvisor.onRequest()")
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        Map<String, String[]> paramMap = request.getParameterMap();
        String params = "";
        if (!paramMap.isEmpty()) {
            params = " [" + paramMapToString(paramMap) + "]";
        }

        long start = System.currentTimeMillis();
        try {
            return pjp.proceed(pjp.getArgs());
        } finally {
            long end = System.currentTimeMillis();
            logger.info("Request: {} {}{} < {} ({}ms)", request.getMethod(),
                    request.getRequestURI(),
                    params, request.getRemoteHost(), end - start);
        }
    }
}
