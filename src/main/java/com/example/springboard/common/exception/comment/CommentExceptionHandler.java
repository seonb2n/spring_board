package com.example.springboard.common.exception.comment;

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
public class CommentExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CommentContentFormatErrorException.class)
    public ResponseEntity<ErrorResponse> handleCommentContentFormatErrorException(CommentContentFormatErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CommentModifyWrongPasswordErrorException.class)
    public ResponseEntity<ErrorResponse> handleCommentModifyWrongPasswordErrorException(CommentModifyWrongPasswordErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CommentDeleteErrorException.class)
    public ResponseEntity<ErrorResponse> handleCommentDeleteErrorException(CommentDeleteErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CommentModifyErrorException.class)
    public ResponseEntity<ErrorResponse> handleCommentModifyErrorException(CommentModifyErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CommentViewErrorException.class)
    public ResponseEntity<ErrorResponse> handleCommentViewErrorException(CommentViewErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CommentCreateErrorException.class)
    public ResponseEntity<ErrorResponse> handleCommentCreateErrorException(CommentCreateErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
