package com.example.springboard.common.handler;

import com.example.springboard.common.ErrorResponse;
import com.example.springboard.common.exception.article.ArticleContentFormatErrorException;
import com.example.springboard.common.exception.article.ArticleCreateErrorException;
import com.example.springboard.common.exception.article.ArticleDeleteErrorException;
import com.example.springboard.common.exception.article.ArticleDeleteWrongPasswordErrorException;
import com.example.springboard.common.exception.article.ArticleModifyErrorException;
import com.example.springboard.common.exception.article.ArticleModifyWrongPasswordErrorException;
import com.example.springboard.common.exception.article.ArticleTitleFormatErrorException;
import com.example.springboard.common.exception.article.ArticleViewErrorException;
import com.example.springboard.util.enums.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ArticleExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ArticleContentFormatErrorException.class)
    public ResponseEntity<ErrorResponse> handleArticleContentFormatErrorException(ArticleContentFormatErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArticleDeleteWrongPasswordErrorException.class)
    public ResponseEntity<ErrorResponse> handleArticleDeleteWrongPasswordErrorException(ArticleDeleteWrongPasswordErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArticleTitleFormatErrorException.class)
    public ResponseEntity<ErrorResponse> handleArticleTitleFormatErrorException(ArticleTitleFormatErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArticleModifyWrongPasswordErrorException.class)
    public ResponseEntity<ErrorResponse> handleArticleModifyWrongPasswordErrorException(ArticleModifyWrongPasswordErrorException exception) {
        logger.info("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.UNAUTHORIZED, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ArticleViewErrorException.class)
    public ResponseEntity<ErrorResponse> handleArticleViewErrorException(ArticleViewErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception.getParams(),
            exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArticleCreateErrorException.class)
    public ResponseEntity<ErrorResponse> handleArticleCreateErrorException(ArticleCreateErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception.getParams(),
            exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArticleDeleteErrorException.class)
    public ResponseEntity<ErrorResponse> handleArticleDeleteErrorException(ArticleDeleteErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception.getParams(),
            exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArticleModifyErrorException.class)
    public ResponseEntity<ErrorResponse> handleArticleModifyErrorException(ArticleModifyErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception.getParams(),
            exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
