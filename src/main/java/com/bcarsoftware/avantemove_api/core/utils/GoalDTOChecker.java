package com.bcarsoftware.avantemove_api.core.utils;

import com.bcarsoftware.avantemove_api.dtos.GoalDTO;
import com.bcarsoftware.avantemove_api.exceptions.BodyException;

import java.util.HashMap;
import java.util.Map;

public class GoalDTOChecker {
    public static void goalDTOChecker(GoalDTO goalDTO) {
        var regex = regexes();

        if (!goalDTO.name().matches(regex.get("name")))
            throw new BodyException("goal name characters not match");

        if (!goalDTO.description().matches(regex.get("description")))
            throw new BodyException("goal description characters not match");
    }

    private static Map<String, String> regexes() {
        var regex = new HashMap<String, String>();

        regex.put("description", "^[a-zA-Z_0-9][a-zA-Z-_ ,.0-9]{1,510}[a-zA-Z.0-9]$");
        regex.put("name", "^[A-Z][a-zA-Z- .]{1,62}[a-zA-Z.]$");

        return regex;
    }
}
