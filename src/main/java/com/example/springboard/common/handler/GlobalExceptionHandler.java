package com.example.springboard.common.handler;

import com.example.springboard.common.exception.GlobalException;
import com.example.springboard.dto.response.CommonErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(GlobalException.class)
    public CommonErrorResponse handleGlobalException(GlobalException exception) {
        // todo logger 처리
        return CommonErrorResponse.of(exception.getErrorType());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CommonErrorResponse handleNoHandlerFoundException(NoHandlerFoundException ex) {
        return CommonErrorResponse.of(ex.getStatusCode().value(), ex.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public CommonErrorResponse handleMethodNotSupportedException(
        HttpRequestMethodNotSupportedException ex) {
        return CommonErrorResponse.of(ex.getStatusCode().value(), ex.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public CommonErrorResponse handleHttpMediaTypeNotSupportedException(
        HttpMediaTypeNotSupportedException ex) {
        return CommonErrorResponse.of(ex.getStatusCode().value(), ex.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public CommonErrorResponse handleHttpMediaTypeNotAcceptableException(
        HttpMediaTypeNotAcceptableException ex) {
        return CommonErrorResponse.of(ex.getStatusCode().value(), ex.getMessage());
    }

}
