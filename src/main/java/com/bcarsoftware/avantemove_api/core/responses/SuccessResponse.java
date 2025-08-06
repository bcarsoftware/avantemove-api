package com.bcarsoftware.avantemove_api.core.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessResponse <T> {
    private T data;
    private int code;
}
