package com.bcarsoftware.avantemove_api.exceptions;

import lombok.Getter;

@Getter
public class DatabaseException extends RuntimeException {
    private int code = 400;

    public  DatabaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public DatabaseException(String message) {
        super(message);
    }
}
