package com.bcarsoftware.avantemove_api.dtos;

import java.time.LocalDate;
import java.util.Optional;

public record UserDTO(
        String firstName,
        String lastName,
        LocalDate birthDate,
        String gender, // TODO: EnumGender
        String username,
        String email,
        String password,
        Optional<String> mobile,
        int experience,
        boolean active
) {
}
