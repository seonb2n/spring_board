package com.example.springboard.common.handler;

import com.example.springboard.common.ErrorResponse;
import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.util.enums.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handleException(GlobalException exception) {
        switch (exception.getLogLevel()) {
            case INFO -> logger.info("Exception: occurred : " + exception.getMessage(), exception);
            case WARN -> logger.warn("Exception: occurred : " + exception.getMessage(),
                exception.getParams(), exception);
            case ERROR -> logger.error("Exception: occurred : " + exception.getMessage(),
                exception.getParams(), exception);
            default -> logger.info("Exception: occurred : " + exception.getMessage(),
                exception.getParams(), exception);
        }

        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST,
            exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
