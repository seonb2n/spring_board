package com.example.springboard.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseInfoException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(BaseInfoException.class);

    public BaseInfoException(String message) {
        super(message);
        logInfo(message);
    }

    public BaseInfoException(String message, Throwable cause) {
        super(message, cause);
        logInfo(message, cause);
    }

    private void logInfo(String message) {
        logger.info(message);
    }

    private void logInfo(String message, Throwable cause) {
        logger.info(message, cause);
    }
}
