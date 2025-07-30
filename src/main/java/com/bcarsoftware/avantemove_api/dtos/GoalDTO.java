package com.bcarsoftware.avantemove_api.dtos;

import com.bcarsoftware.avantemove_api.core.utils.GoalDTOChecker;

import java.time.LocalDate;

public record GoalDTO(
        Long userId,
        String name,
        String description,
        LocalDate startDate,
        LocalDate finishDate,
        boolean active
) {
    public GoalDTO {
        GoalDTOChecker.goalDTOChecker(this);
    }
}
