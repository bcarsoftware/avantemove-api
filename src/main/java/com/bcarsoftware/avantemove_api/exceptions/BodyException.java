package com.bcarsoftware.avantemove_api.exceptions;

import lombok.Getter;

@Getter
public class BodyException extends RuntimeException {
    private int code = 400;

    public BodyException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BodyException(String message) {
        super(message);
    }
}
