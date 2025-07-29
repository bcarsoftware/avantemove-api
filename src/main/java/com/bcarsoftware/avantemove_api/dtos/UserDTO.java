package com.bcarsoftware.avantemove_api.dtos;

import com.bcarsoftware.avantemove_api.enums.EnumGender;

import java.time.LocalDate;
import java.util.Optional;

public record UserDTO(
        String firstName,
        String lastName,
        LocalDate birthDate,
        EnumGender gender,
        String username,
        String email,
        String password,
        Optional<String> mobile,
        int experience,
        boolean active
) {
}
