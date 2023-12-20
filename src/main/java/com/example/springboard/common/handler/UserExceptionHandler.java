package com.example.springboard.common.handler;

import com.example.springboard.common.ErrorResponse;
import com.example.springboard.common.exception.user.AlreadyJoinedUserErrorException;
import com.example.springboard.common.exception.user.ExistIdErrorException;
import com.example.springboard.common.exception.user.FindIdNoUserErrorException;
import com.example.springboard.common.exception.user.NicknameFormatErrorException;
import com.example.springboard.common.exception.user.PasswordFormatErrorException;
import com.example.springboard.common.exception.user.ResetPasswordErrorException;
import com.example.springboard.common.exception.user.VerifyRealErrorException;
import com.example.springboard.util.enums.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(AlreadyJoinedUserErrorException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyJoinedUserErrorException(AlreadyJoinedUserErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistIdErrorException.class)
    public ResponseEntity<ErrorResponse> handleExistIdErrorException(ExistIdErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FindIdNoUserErrorException.class)
    public ResponseEntity<ErrorResponse> handleFindIdNoUserErrorException(FindIdNoUserErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NicknameFormatErrorException.class)
    public ResponseEntity<ErrorResponse> handleNicknameFormatErrorException(NicknameFormatErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordFormatErrorException.class)
    public ResponseEntity<ErrorResponse> handlePasswordFormatErrorException(PasswordFormatErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(VerifyRealErrorException.class)
    public ResponseEntity<ErrorResponse> handleVerifyRealErrorException(VerifyRealErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception.getParams(),
            exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResetPasswordErrorException.class)
    public ResponseEntity<ErrorResponse> handleResetPasswordErrorException(ResetPasswordErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception.getParams(),
            exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
