package com.example.springboard.common.handler;

import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.dto.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(GlobalException.class)
    public ErrorResponse handleException(GlobalException exception) {
        // todo logger 처리
        return ErrorResponse.of(exception.getErrorType());
    }
}
