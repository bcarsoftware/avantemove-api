package com.bcarsoftware.avantemove_api.core.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    private int code;
}
