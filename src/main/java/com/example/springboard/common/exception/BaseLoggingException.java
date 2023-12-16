package com.example.springboard.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseLoggingException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(BaseLoggingException.class);

    public BaseLoggingException(String message, LOG_LEVEL logLevel) {
        super(message);
        logException(message, logLevel);
    }

    private void logException(String message, LOG_LEVEL logLevel) {
        switch (logLevel) {
            case INFO -> logger.info(message);
            case WARN -> logger.warn(message);
            case ERROR -> logger.error(message);
        }
    }

    public enum LOG_LEVEL {
        INFO,
        WARN,
        ERROR
    }
}
