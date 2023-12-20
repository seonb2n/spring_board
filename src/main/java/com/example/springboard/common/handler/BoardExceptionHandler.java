package com.example.springboard.common.handler;

import com.example.springboard.common.ErrorCode;
import com.example.springboard.common.ErrorResponse;
import com.example.springboard.common.exception.board.CreateBoardErrorException;
import com.example.springboard.common.exception.board.DeleteBoardErrorException;
import com.example.springboard.common.exception.board.GetArticleListErrorException;
import com.example.springboard.common.exception.board.GetListException;
import com.example.springboard.common.exception.board.ModifyBoardScopeErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BoardExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(GetArticleListErrorException.class)
    public ResponseEntity<ErrorResponse> handleGetArticleListErrorException(GetArticleListErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GetListException.class)
    public ResponseEntity<ErrorResponse> handleGetListException(GetListException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ModifyBoardScopeErrorException.class)
    public ResponseEntity<ErrorResponse> handleModifyBoardScopeErrorException(ModifyBoardScopeErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CreateBoardErrorException.class)
    public ResponseEntity<ErrorResponse> handleCreateBoardErrorException(CreateBoardErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DeleteBoardErrorException.class)
    public ResponseEntity<ErrorResponse> handleDeleteBoardErrorException(DeleteBoardErrorException exception) {
        logger.error("Exception: occurred : " + exception.getMessage(), exception);
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
