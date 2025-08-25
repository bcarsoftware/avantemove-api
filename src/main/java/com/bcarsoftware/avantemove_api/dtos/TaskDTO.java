package com.bcarsoftware.avantemove_api.dtos;

import java.time.LocalDate;

public record TaskDTO(
        Long habitId,
        String name,
        String comment,
        int xpValue,
        LocalDate date,
        boolean finished
) { }
