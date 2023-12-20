package com.example.springboard.common.exception.token;

import com.example.springboard.common.exception.GlobalException;

public class TokenNotFoundException extends GlobalException {

    public TokenNotFoundException() {
    }

    public TokenNotFoundException(String message) {
        super(message);
    }

    public TokenNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenNotFoundException(Throwable cause) {
        super(cause);
    }
}
