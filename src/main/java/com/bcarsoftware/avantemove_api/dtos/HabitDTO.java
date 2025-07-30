package com.bcarsoftware.avantemove_api.dtos;

import com.bcarsoftware.avantemove_api.core.utils.HabitDTOChecker;
import com.bcarsoftware.avantemove_api.enums.EnumWeek;

import java.util.List;
import java.util.Optional;

public record HabitDTO(
        Long userId,
        Optional<Long> goalId,
        String name,
        String category,
        List<EnumWeek> daysWeek,
        boolean active
) {
    public HabitDTO {
        HabitDTOChecker.habitDTOChecker(this);
    }
}
