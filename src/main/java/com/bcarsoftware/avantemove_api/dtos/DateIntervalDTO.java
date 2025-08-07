package com.bcarsoftware.avantemove_api.dtos;

import com.bcarsoftware.avantemove_api.exceptions.BodyException;

import java.time.LocalDate;

public record DateIntervalDTO(
    LocalDate start,
    LocalDate end
) {
    public DateIntervalDTO {
        if (end.isBefore(start))
            throw new BodyException("date interval invalid");
    }
}
