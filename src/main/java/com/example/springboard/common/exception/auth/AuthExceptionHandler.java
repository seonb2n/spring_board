package com.example.springboard.common.exception.auth;

import com.example.springboard.common.ErrorCode;
import com.example.springboard.common.ErrorResponse;
import com.example.springboard.common.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AuthErrorException.class)
    public ResponseEntity<ErrorResponse> handleAuthErrorException(AuthErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.UNAUTHORIZED, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(LoginErrorException.class)
    public ResponseEntity<ErrorResponse> handleLoginErrorException(LoginErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongCallErrorException.class)
    public ResponseEntity<ErrorResponse> handleWrongCallErrorException(WrongCallErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.FORBIDDEN, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

}
