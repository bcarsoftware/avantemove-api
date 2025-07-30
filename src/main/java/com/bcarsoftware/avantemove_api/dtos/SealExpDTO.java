package com.bcarsoftware.avantemove_api.dtos;

import com.bcarsoftware.avantemove_api.core.utils.SealExpDTOChecker;

public record SealExpDTO(
        String name,
        int startXp,
        int finishXp
) {
    public SealExpDTO {
        SealExpDTOChecker.sealExpDTOChecker(this);
    }
}
