package com.bcarsoftware.avantemove_api.core.handlers;

import com.bcarsoftware.avantemove_api.core.responses.ErrorResponse;
import com.bcarsoftware.avantemove_api.exceptions.AuthException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionHandler {
    @ExceptionHandler(AuthException.class)
    public static ResponseEntity<ErrorResponse> handleAuthException(AuthException except) {
        ErrorResponse error = new ErrorResponse();
        error.setMessage(except.getMessage());
        error.setCode(except.getCode());

        return ResponseEntity.status(error.getCode()).body(error);
    }
}
