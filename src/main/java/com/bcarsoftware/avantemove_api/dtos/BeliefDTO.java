package com.bcarsoftware.avantemove_api.dtos;

import com.bcarsoftware.avantemove_api.core.utils.BeliefDTOChecker;

public record BeliefDTO(
        Long userId,
        String description
) {
    public BeliefDTO {
        BeliefDTOChecker.beliefDTOChecker(this);
    }
}
