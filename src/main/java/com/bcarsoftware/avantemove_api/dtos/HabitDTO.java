package com.bcarsoftware.avantemove_api.dtos;

import java.util.List;
import java.util.Optional;

public record HabitDTO(
        Long userId,
        Optional<Long> goalId,
        String name,
        String category,
        List<Integer> daysWeek,
        boolean active
) {
}
