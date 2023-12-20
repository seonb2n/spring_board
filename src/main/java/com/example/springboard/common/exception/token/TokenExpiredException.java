package com.example.springboard.common.exception.token;

import com.example.springboard.common.exception.GlobalException;

public class TokenExpiredException extends GlobalException {

    public TokenExpiredException() {
    }

    public TokenExpiredException(String message) {
        super(message);
    }

    public TokenExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenExpiredException(Throwable cause) {
        super(cause);
    }
}
