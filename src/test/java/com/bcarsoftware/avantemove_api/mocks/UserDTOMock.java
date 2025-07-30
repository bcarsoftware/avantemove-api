package com.bcarsoftware.avantemove_api.mocks;

import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import com.bcarsoftware.avantemove_api.enums.EnumGender;

import java.time.LocalDate;
import java.util.Optional;

public class UserDTOMock {
    public static UserDTO success() {
        return new UserDTO(
            "Maria",
            "Nunes",
            LocalDate.of(2000, 5, 17),
            EnumGender.MALE,
            "username",
            "abelbnc@gmail.com",
            "658271AB",
            Optional.empty(),
            10,
            true
        );
    }

    public static UserDTO failedFirstName() {
        return new UserDTO(
                "5",
                "Nunes",
                LocalDate.of(2000, 5, 17),
                EnumGender.MALE,
                "username",
                "abelbnc@gmail.com",
                "658271AB",
                Optional.empty(),
                10,
                true
        );
    }

    public static UserDTO failedLastName() {
        return new UserDTO(
                "Maria",
                "8",
                LocalDate.of(2000, 5, 17),
                EnumGender.MALE,
                "username",
                "abelbnc@gmail.com",
                "658271AB",
                Optional.empty(),
                10,
                true
        );
    }

    public static UserDTO failedEmail() {
        return new UserDTO(
                "Maria",
                "Nunes",
                LocalDate.of(2000, 5, 17),
                EnumGender.MALE,
                "username",
                "domain.gmail.com",
                "658271AB",
                Optional.empty(),
                10,
                true
        );
    }

    public static UserDTO failedUsername() {
        return new UserDTO(
                "Maria",
                "Nunes",
                LocalDate.of(2000, 5, 17),
                EnumGender.MALE,
                "",
                "abelbnc@gmail.com",
                "658271AB",
                Optional.empty(),
                10,
                true
        );
    }

    public static UserDTO failedPassword() {
        return new UserDTO(
                "Maria",
                "Nunes",
                LocalDate.of(2000, 5, 17),
                EnumGender.MALE,
                "username",
                "abelbnc@gmail.com",
                "658271",
                Optional.empty(),
                10,
                true
        );
    }

    public static UserDTO failedMobileNumber() {
        return new UserDTO(
                "Maria",
                "Nunes",
                LocalDate.of(2000, 5, 17),
                EnumGender.MALE,
                "username",
                "abelbnc@gmail.com",
                "658271AB",
                Optional.of("174585"),
                10,
                true
        );
    }
}
