package com.bcarsoftware.avantemove_api.dtos;

public record TaskDTO(
        Long habitId,
        String comment,
        Long xpValue,
        boolean finished
) { }
