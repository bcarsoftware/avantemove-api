package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import com.bcarsoftware.avantemove_api.enums.EnumGender;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

import java.util.*;

public class UserDTOChecker {
    public static void userDTOChecker(UserDTO userDTO) {
        Map<String, String> regex = regexes();

        if (!userDTO.firstName().matches(regex.get("firstName")))
            throw new BodyException("first name characters not match");

        if (!userDTO.lastName().matches(regex.get("lastName")))
            throw new BodyException("last name characters not match");

        if (!List.of(EnumGender.values()).contains(userDTO.gender()))
            throw new BodyException("invalid value for gender");

        if (!userDTO.username().matches(regex.get("username")))
            throw new BodyException("username characters not match");

        if (!userDTO.email().matches(regex.get("email")))
            throw new BodyException("email characters not match");

        if (!userDTO.password().matches(regex.get("password")))
            throw new BodyException("password characters not match");

        if (userDTO.mobile().isPresent() && userDTO.mobile().get().matches(regex.get("mobile")))
            throw new BodyException("mobile characters not match");

        if (userDTO.experience() < 0)
            throw new BodyException("experience cannot be negative");
    }

    private static Map<String, String> regexes() {
        Map<String, String> regex = new HashMap<>();

        regex.put("email",
            "^[a-z][a-z0-9._-]{1,254}[a-z0-9]@[a-z0-9]{1,16}(.[a-z]{2,3}){1,2}$"
        );

        regex.put("username", "^[a-z][a-z-_0-9]{1,254}$");

        regex.put("mobile", "^[0-9]{13}$");

        regex.put("firstName", "^[A-Z][a-zA-Z- .]{0,30}[a-zA-Z.]$");

        regex.put("lastName", "^[A-Z][a-zA-Z- .]{1,253}[a-zA-Z.]$");

        regex.put("description",
            "^[a-zA-Z_0-9][a-zA-Z-_ ,.0-9]{1,510}[a-zA-Z.0-9]$"
        );

        regex.put("password", "^[\\S+]{8,32}$");

        return regex;
    }
}
