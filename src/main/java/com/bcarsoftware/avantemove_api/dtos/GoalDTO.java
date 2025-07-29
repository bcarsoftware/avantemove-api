package com.bcarsoftware.avantemove_api.dtos;

import java.time.LocalDate;

public record GoalDTO(
        Long userId,
        String name,
        String description,
        LocalDate startDate,
        LocalDate finishDate,
        boolean active
) {
}
