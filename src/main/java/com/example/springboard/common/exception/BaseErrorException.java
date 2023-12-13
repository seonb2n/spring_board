package com.example.springboard.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseErrorException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(BaseErrorException.class);

    public BaseErrorException(String message) {
        super(message);
        logError(message);
    }

    public BaseErrorException(String message, Throwable cause) {
        super(message, cause);
        logError(message, cause);
    }

    private void logError(String message) {
        logger.error(message);
    }

    private void logError(String message, Throwable cause) {
        logger.error(message, cause);
    }
}
