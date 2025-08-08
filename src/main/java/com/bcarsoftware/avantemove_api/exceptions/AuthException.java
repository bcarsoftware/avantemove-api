package com.bcarsoftware.avantemove_api.exceptions;

import lombok.Getter;

@Getter
public class AuthException extends RuntimeException {
    private final int code = 401;

    public AuthException(String message) {
        super(message);
    }
}
