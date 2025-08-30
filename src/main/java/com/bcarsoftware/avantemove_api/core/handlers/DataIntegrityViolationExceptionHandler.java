package com.bcarsoftware.avantemove_api.core.handlers;

import com.bcarsoftware.avantemove_api.core.responses.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DataIntegrityViolationExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public static ResponseEntity<ErrorResponse> handleDatabaseException(DataIntegrityViolationException except) {
        System.err.println(except.getMostSpecificCause().getMessage());

        ErrorResponse error = new ErrorResponse();
        error.setMessage("problem with data integrity at database level");
        error.setCode(422);

        return ResponseEntity.status(error.getCode()).body(error);
    }
}
