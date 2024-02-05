package com.example.springboard.common.handler;

import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.dto.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handleException(GlobalException exception) {
        // todo logger 처리
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorType());
        if (exception.getErrorType().getCode() >= 500_000) {
            return ResponseEntity.internalServerError().body(errorResponse);
        } else if (exception.getErrorType().getCode() >= 400_000) {
            return ResponseEntity.badRequest().body(errorResponse);
        }
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
