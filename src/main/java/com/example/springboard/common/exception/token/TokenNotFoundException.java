package com.example.springboard.common.exception.token;

import com.example.springboard.common.exception.GlobalException;

public class TokenNotFoundException extends GlobalException {

    public TokenNotFoundException(String message) {
        super(message);
    }

}
