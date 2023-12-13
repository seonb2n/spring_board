package com.example.springboard.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseWarnException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(BaseWarnException.class);

    public BaseWarnException(String message) {
        super(message);
        logWarn(message);
    }

    public BaseWarnException(String message, Throwable cause) {
        super(message, cause);
        logWarn(message, cause);
    }

    private void logWarn(String message) {
        logger.warn(message);
    }

    private void logWarn(String message, Throwable cause) {
        logger.warn(message, cause);
    }
}
